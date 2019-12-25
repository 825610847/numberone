package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车，收藏夹，订单父类
 * @author 李源仑
 */
@Data
public class UserBusiness extends BaseEntity{
    /**ID*/
    private Long businessId;
    /**商品ID*/
    private Long goodId;
    /**用户ID*/
    private Long userId;
}
