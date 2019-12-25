package com.gt.controller;

import com.gt.entity.GoodProperty;
import com.gt.service.FindGoodByMyIdServer;
import com.gt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 何水告
 * @create 2019/12/25
 * 男人之所以努力，是为了获得更好的交配权
 */
@RestController
@RequestMapping("/good")
public class FindGoodByMyIdController {
    @Autowired
    private FindGoodByMyIdServer findGoodByMyIdServer;

    @RequestMapping("/find")//根据卖家id寻找他发布的商品
    public List<GoodProperty> findGoodByMyId(Long sellerId){
        List<GoodProperty>list=findGoodByMyIdServer.findGoodByMyIds(sellerId);
        return list;
    }

    @RequestMapping("/delete")//用户删除自己发布的商品
    public SysResult deleteMyGood(Long goodId){
        findGoodByMyIdServer.deleteGood(goodId);
        return SysResult.success();
    }
}
