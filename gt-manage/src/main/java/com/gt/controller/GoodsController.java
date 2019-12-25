package com.gt.controller;

import com.gt.entity.GoodProperty;
import com.gt.service.GoodsService;
import com.gt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 用户上架自己要卖的商品信息
     * @param goodProperty
     * @return
     */
    @RequestMapping("/publish")
    public SysResult publishGoods(GoodProperty goodProperty){
        goodsService.publishGoods(goodProperty);
        return SysResult.success();
    }

}