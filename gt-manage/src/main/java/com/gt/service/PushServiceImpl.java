package com.gt.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gt.entity.GameInfo;
import com.gt.mapper.PushMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PushServiceImpl implements DubboPushService {
    @Autowired
    private PushMapper pushMapper;

    @Override
    public List<GameInfo> getHotList(Integer index) {
        return pushMapper.getNewList(index);
    }

    @Override
    public List<GameInfo> getNewList(Integer index) {
        return pushMapper.getNewList(index);
    }
}
