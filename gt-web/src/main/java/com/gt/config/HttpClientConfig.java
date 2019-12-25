package com.gt.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:/properties/httpClient.properties")
public class HttpClientConfig {

    @Value("${http.maxTotal}")
    private Integer maxTotal; //最大连接数

    @Value("${http.defaultMaxPerRoute}")
    private  Integer defaultMaxPerRoute; //最大并发链接数

    @Value("${http.connectTimeout}")
    private Integer connectTimeout; //创建链接的最大时间

    @Value("${http.connectionRequestTimeout}")
    private Integer connectionRequestTimeout;		//链接获取超时时间

    @Value("${http.socketTimeout}")
    private Integer socketTimeout;			  		//数据传输最长时间

    @Value("${http.staleConnectionCheckEnabled}")
    private boolean staleConnectionCheckEnabled; 	//提交时检查链接是否可用

    //配置httpClient连接池
    @Bean(name = "httpClientConnectionManager")
    public PoolingHttpClientConnectionManager
    getPoolingHttpClientConnectionManager(){
        PoolingHttpClientConnectionManager manager =
                new PoolingHttpClientConnectionManager();
        manager.setMaxTotal(maxTotal);//最大链接数
        manager.setDefaultMaxPerRoute(defaultMaxPerRoute);//最大并发连接数
        return manager;
    }
    //定义HttpClient
    @Bean("httpClientBuilder")
    public HttpClientBuilder
    //将自动注入的连接池作为参数传入
        getHttpClientBuilder(@Qualifier("httpClientConnectionManager")
        PoolingHttpClientConnectionManager httpClientConnectionManager){
        //创建一个HttpClientBuilder实例
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //为HttpClientBuilder设置连接池
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        return httpClientBuilder;
    }

    //注入Builder，用于获取httpClient
    @Bean
    public CloseableHttpClient getCloseableHttpClient(
            @Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder){
        return httpClientBuilder.build();
    }

    //配置类的builder，设置配置信息
    @Bean(name="builder")
    public RequestConfig.Builder getBuilder(){
        RequestConfig.Builder builder = RequestConfig.custom();
        return builder.setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .setStaleConnectionCheckEnabled(staleConnectionCheckEnabled);
    }

    //注入配置信息builder，调用build()方法返回配置信息RequestConfig
    @Bean
    public RequestConfig getRequestConfig(@Qualifier("builder") RequestConfig.Builder builder){
        return builder.build();
    }
}
