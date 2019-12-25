package com.gt.mapper.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gt.entity.GameInfo;
import com.gt.mapper.PushMapper;
import com.gt.service.DubboPushService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPush {
    @Autowired
    private PushMapper pushMapper;
//    @Reference(check = false)
//    private DubboPushService pushService;
    @Test
    public void testGetNewList() {
//        System.out.println(pushService);
        List<GameInfo> newList = pushMapper.getNewList(0);
        for (GameInfo gameInfo : newList) {
            System.out.println(gameInfo);
        }
//        GameInfo description = pushMapper.getDescription((long) 1);
//        System.out.println(description);

    }
}
