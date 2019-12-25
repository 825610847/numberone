package com.gt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gt.entity.GameInfo;

import java.util.List;

public interface PushMapper extends BaseMapper<GameInfo> {
    List<GameInfo> getHotList();
    List<GameInfo> getNewList(Integer index);
}
