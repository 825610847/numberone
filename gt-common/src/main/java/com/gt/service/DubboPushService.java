package com.gt.service;

import com.gt.entity.GameInfo;

import java.util.List;

public interface DubboPushService {
    List<GameInfo> getHotList(Integer index);
    List<GameInfo> getNewList(Integer index);
}
