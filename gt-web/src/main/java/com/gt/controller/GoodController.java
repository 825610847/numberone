package com.gt.controller;

import com.gt.service.GoodService;
import com.gt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/good/")
public class GoodController {

    @Autowired
    GoodService goodService;

    @RequestMapping("search")
    @ResponseBody
    public SysResult getGoodById(){
        Integer id = 1;
        return goodService.getGoodById(id);
    }
}
