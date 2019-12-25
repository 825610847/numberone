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
        return pushMapper.getHotList(index);
    }

    @Override
    public List<GameInfo> getNewList(Integer index) {
        List<GameInfo> newList = pushMapper.getNewList(index);
        for (GameInfo gameInfo : newList) {
            Long gameId = gameInfo.getGameId();
            GameInfo description = pushMapper.getDescription(gameId);
            gameInfo.setGameImage(description.getGameImage());
            gameInfo.setGameDescription(description.getGameDescription());
        }

        return newList;
    }
}
