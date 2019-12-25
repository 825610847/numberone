package com.gt.mapper;

import com.gt.entity.GoodProperty;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 何水告
 * @create 2019/12/25
 * 男人之所以努力，是为了获得更好的交配权
 */
@Mapper
public interface FindGoodByMyIdMapper {
    @Select("select * from good_property where seller_id=#{sellerId}")
    List<GoodProperty> selectMyGood(Long sellerId);
    @Delete("delete from good_property where good_id=#{goodId}")
    void deleteGood(Long goodId);
}
