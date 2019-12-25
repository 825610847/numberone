package com.gt.controller;

import com.gt.entity.UserAddr;
import com.gt.service.FindUserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 何水告
 * @create 2019/12/24
 * 男人之所以努力，是为了获得更好的交配权
 */
@RestController
@RequestMapping("/addr")
public class FindUserAddrController {
    @Autowired
    private FindUserAddrService findUserAddrService;

    @RequestMapping("/query")
    public List<UserAddr> findUserAddrById(Integer userCatAddressId){
        List<UserAddr> userAddr=findUserAddrService.getUserAddrById(userCatAddressId);
        return userAddr;
    }
}
