package com.gt.service;

import com.gt.entity.GoodProperty;

import java.util.List;

/**
 * 商品服务层
 * @author 李源仑
 */
public interface GoodPropertyService {
    /**
     * 按照搜索字符串查询商品
     * @param searchValue
     * @return
     */
    public List<GoodProperty> selectGoodProperty(String searchValue);
    /**
     * 按照对应分类查询商品，分类编号为整型
     * @param typeId
     * @return
     */
    public List<GoodProperty> selectGoodPropertyByTypeId(Integer typeId);
}
