package com.gt.mapper;

import com.gt.entity.GoodProperty;

import java.util.List;

/**
 * 商品DAO层
 * @author 李源仑
 */
public interface GoodPropertyMapper {
    /**
     * 按照搜索字符串查询商品
     *
     * @param searchValue
     * @return
     */
    List<GoodProperty> selectGoodBySearchValue(String searchValue);

    /**
     * 按照对应分类查询商品，分类编号为整型
     *
     * @param typeId
     * @return
     */
    List<GoodProperty> selectGoodByTypeId(Integer typeId);
}
