package com.gt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gt.entity.UserAddr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface FindUserAddrMapper extends BaseMapper<UserAddr> {
    @Select(" select * from user_delivery_address where user_cat_address_id=#{userCatAddressId}")
    List<UserAddr> selectUserAddrById(Integer userCatAddressId);
}
