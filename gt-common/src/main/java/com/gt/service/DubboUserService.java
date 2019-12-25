package com.gt.service;


import com.gt.entity.UserProperty;

/**
 * 定义中立的第三方接口.
 * @author Administrator
 *
 */
public interface DubboUserService {


    void insertUser(UserProperty user);
}
