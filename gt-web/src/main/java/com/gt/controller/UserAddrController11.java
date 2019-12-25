package com.gt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gt.entity.UserAddr;
import com.gt.service.DoubboAddrService11;
import com.gt.service.DubboUserService;
import com.gt.vo.SysResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAddrController11 {
    @Reference(check = false)
    private DoubboAddrService11 doubboAddrService11;

    @RequestMapping("/addAddr")
    public SysResult addAddr(UserAddr userAddr){
        Integer add = doubboAddrService11.add(userAddr);
        if(add>0){
            return  SysResult.success();
        }else {
            return  SysResult.fail();
        }
    }
    @RequestMapping("/updateAddr")
    public  SysResult updateAddr(UserAddr userAddr){
        Integer add = doubboAddrService11.update(userAddr);
        if(add>0){
            return  SysResult.success();
        }else {
            return  SysResult.fail();
        }

    }
    @RequestMapping("/deleteAddr")
    public  SysResult deleteAddr(Integer AddrId,Integer UserId){
        Integer add = doubboAddrService11.delete(AddrId,UserId);
        if(add>0){
            return  SysResult.success();
        }else {
            return  SysResult.fail();
        }

    }
}
