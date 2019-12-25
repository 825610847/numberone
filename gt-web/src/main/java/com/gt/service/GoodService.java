package com.gt.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gt.vo.SysResult;

@Service
public interface GoodService {
    SysResult getGoodById(Integer id);
}
