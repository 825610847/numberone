package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder extends UserBusiness{
    /**订单状态*/
    private Integer orderStatus;
}
