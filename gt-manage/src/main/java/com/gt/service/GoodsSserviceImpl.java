package com.gt.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gt.entity.GoodProperty;
import com.gt.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Service
public class GoodsSserviceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void publishGoods(GoodProperty goodProperty) {

        goodProperty.setGoodStatus(1)
                .setCreateTime(new Date())
                .setUpdateTime(goodProperty.getCreateTime());
        goodsMapper.insert(goodProperty);
    }
}
