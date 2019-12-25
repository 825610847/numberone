package com.gt.service;

import com.gt.vo.SysResult;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    SysResult login(String username, String pwd);
}
