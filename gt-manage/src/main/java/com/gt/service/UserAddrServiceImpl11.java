package com.gt.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gt.entity.UserAddr;
import com.gt.mapper.UserAddrMapper11;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Service
public class UserAddrServiceImpl11 implements DoubboAddrService11 {

    @Autowired
    private UserAddrMapper11 userAddrMapper;

    @Override
    public Integer add(UserAddr userAddr) {
        userAddr.setCreateTime(new Date());
        userAddr.setUpdateTime(new Date());
        int row = userAddrMapper.insert(userAddr);
        return  row;
    }

    @Override
    public Integer update(UserAddr userAddr) {
        userAddr.setUpdateTime(new Date());
        int row = userAddrMapper.updateById(userAddr);
        return row;
    }

    @Override
    public Integer delete(Integer addrId, Integer userId) {
        QueryWrapper<UserAddr> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("deliveryAddressId",addrId);
        queryWrapper.eq("userCatAddressId",userId);
        int row = userAddrMapper.delete(queryWrapper);
        return row;
    }
}
