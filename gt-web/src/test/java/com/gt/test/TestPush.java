package com.gt.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gt.entity.GameInfo;
import com.gt.service.DubboPushService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPush {
    @Reference(check = false)
    private DubboPushService pushService;

    @Test
    public void testGetNewList() {
//        System.out.println(pushService);
        List<GameInfo> newList = pushService.getNewList(0);
        System.out.println(newList);


    }
}
