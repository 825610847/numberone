package com.gt.client;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class HttpClientClose extends Thread {
    @Autowired
    private PoolingHttpClientConnectionManager manage;

    private volatile  boolean shutdown;
    public HttpClientClose(){
        this.start();
    }

    public void run(){
        try{
            while(!shutdown){
                synchronized (this){
                    wait(5000);
                }
                PoolStats stats = manage.getTotalStats();
                int av = stats.getAvailable();//获取可用的线程数量
                int pend = stats.getPending();//获取阻塞的线程数量
                int lea = stats.getLeased();//获取当前正在使用的链接数量
                int max = stats.getMax();
                manage.closeExpiredConnections();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        super.run();
    }

    @PreDestroy
    public void shutdown(){
        shutdown = true;
        synchronized (this){
            notify();//执行关闭操作
        }
    }
}
