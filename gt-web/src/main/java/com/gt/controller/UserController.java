package com.gt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gt.service.UserService;
import com.gt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user/")
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("login")
    public SysResult getGoodById(String username, String password){
        return userService.login(username,password);
    }
}
