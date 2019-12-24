package com.gt.controller;

import com.gt.entity.GoodProperty;
import com.gt.service.GoodPropertyService;
import com.gt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/searchGoods")
public class ManageController {
    @Autowired
    private GoodPropertyService goodPropertyService;

    @GetMapping("/{typeId}")
    public SysResult searchGoods(@PathVariable Integer typeId){
        List<GoodProperty> goodProperties = goodPropertyService.selectGoodPropertyByTypeId(typeId);
        return goodProperties != null ? SysResult.success(goodProperties) : SysResult.fail();
    }

    @GetMapping("?wd={searchValue}")
    public SysResult searchGoods(@PathVariable String searchValue){
        List<GoodProperty> goodProperties = goodPropertyService.selectGoodProperty(searchValue);
        return goodProperties != null ? SysResult.success(goodProperties) : SysResult.fail();
    }
}
