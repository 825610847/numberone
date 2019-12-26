package com.gt.service;

import com.gt.mapper.GoodPropertyMapper;
import com.gt.entity.GoodProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务层实现类
 * @author 李源仑
 */
@Service
public class GoodPropertyServiceImpl implements GoodPropertyService {

    @Autowired
   private GoodPropertyMapper goodPropertyMapper;
    /**
     * 按照搜索字符串查询商品
     *
     * @param searchValue
     * @return
     */
    @Override
    public List<GoodProperty> selectGoodProperty(String searchValue) {
        return goodPropertyMapper.selectGoodBySearchValue(searchValue);
    }

    /**
     * 按照对应分类查询商品，分类编号为整型
     *
     * @param typeId
     * @return
     */
    @Override
    public List<GoodProperty> selectGoodPropertyByTypeId(Integer typeId) {
        return goodPropertyMapper.selectGoodByTypeId(typeId);
    }
}
