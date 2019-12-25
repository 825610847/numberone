package com.gt.service;

import com.gt.entity.GoodProperty;
import com.gt.mapper.FindGoodByMyIdMapper;
import com.gt.service.FindGoodByMyIdServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 何水告
 * @create 2019/12/25
 * 男人之所以努力，是为了获得更好的交配权
 */
@Service
public class FindGoodByMyIdServerImpl implements FindGoodByMyIdServer {

    @Autowired
    private FindGoodByMyIdMapper findGoodByMyIdMapper;
    @Override
    public List<GoodProperty> findGoodByMyIds(Long sellerId) {
        List<GoodProperty>goods=findGoodByMyIdMapper.selectMyGood(sellerId);
        return goods;
    }

    @Override
    public void deleteGood(Long goodId) {
        findGoodByMyIdMapper.deleteGood(goodId);
    }
}
