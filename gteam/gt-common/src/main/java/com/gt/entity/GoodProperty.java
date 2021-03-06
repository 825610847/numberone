package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *商品属性
 * @author 李源仑
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodProperty extends BaseEntity {
    /**商品ID*/
    private Long goodId;
    /**商品类型ID flase:游戏 true:主机*/
    private boolean goodTypeId;
    /**买家ID*/
    private Long buyerId;
    /**卖家ID*/
    private Long sellerId;
    /**商品名称*/
    private String goodName;
    /**商品类型标签组*/
    private String[] typeLabel;
    /**商品状态*/
    private Integer goodStatus;
    /**商品价格*/
    private Double goodPrice;
    /**商品图片*/
    private String goodPicture;
    /**主机几成新*/
    private Integer goodNewness;
    /**是否支持退货*/
    private boolean isSupportReturn;
    /**商品浏览次数*/
    private Integer goodViewCount;
    /**商品销量*/
    private Integer goodSoldCount;
    /**商品用户评价*/
    private String goodCredit;
}
