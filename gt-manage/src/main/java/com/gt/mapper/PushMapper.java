package com.gt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gt.entity.GameInfo;

import java.util.List;

public interface PushMapper extends BaseMapper<GameInfo> {
    default List<GameInfo> getHotList(Integer index){return getNewList(index);}
    List<GameInfo> getNewList(Integer index);
    GameInfo getDescription(Long gameId);
}
