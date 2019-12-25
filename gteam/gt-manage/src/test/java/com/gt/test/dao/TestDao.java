package com.gt.test.dao;

import com.gt.dao.GoodPropertyMapper;
import com.gt.entity.GoodProperty;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {
    @Autowired(required = true)
    private GoodPropertyMapper goodPropertyMapper;

    public GoodProperty goodProperty = new GoodProperty();
    public List<GoodProperty> goodPropertyList;

    @Test
    public void TestMe(){
        goodPropertyList = goodPropertyMapper.selectGoodBySearchValue("战神");
        for(GoodProperty g : goodPropertyList){
            g.getGoodId();
            g.getGoodName();
            g.getGoodPrice();
        }
    }
}
