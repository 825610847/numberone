package com.gt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 王中林： 地址类的POJO
<<<<<<< Updated upstream
 * 11.查询当前用户的所有地址
 * 12.查询我发布的所有商品
 * 13.删除我发布的商品
 */
@TableName("user_delivery_address")
@Accessors(chain=true)
@Data
public class UserAddr extends BaseEntity{
    @TableId(type= IdType.AUTO)
    Integer deliveryAddressId;   //地址ID
    Integer userCatAddressId;   //用户传递的ID
    String userName;   //用户名
    String userPhone;   //用户电话
    String delivery_address;  //详细地址
}
