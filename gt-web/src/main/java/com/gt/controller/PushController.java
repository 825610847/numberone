package com.gt.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gt.entity.GameInfo;
import com.gt.service.DubboPushService;
import com.gt.vo.SysResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PushController {
    @Reference(check = false)
    private DubboPushService pushService;

    @RequestMapping("/getNewList")
    @ResponseBody
    public SysResult getNewList(Integer index) {
        List<GameInfo> newList = pushService.getNewList(index);
        return SysResult.success(newList);
    }

    @RequestMapping("/getHotList")
    @ResponseBody
    public SysResult getHotList(Integer index) {
        List<GameInfo> newList = pushService.getNewList(index);
        return SysResult.success(newList);
    }
}
