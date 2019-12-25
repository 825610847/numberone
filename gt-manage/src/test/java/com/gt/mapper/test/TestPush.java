package com.gt.mapper.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gt.mapper.PushMapper;
import com.gt.service.DubboPushService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPush {
    @Autowired
    private PushMapper pushMapper;
    @Reference
    private DubboPushService pushService;
    @Test
    public void testGetNewList() {
        System.out.println(pushService);
//        List<GameInfo> newList = pushMapper.getNewList(0);
//        System.out.println(newList);


    }
}
