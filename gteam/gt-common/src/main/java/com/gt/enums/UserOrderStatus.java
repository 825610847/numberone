package com.gt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserOrderStatus {
    CANCELLED(0, "已取消"),
    CLOSED(1, "已关闭"),
    CREATED(2, "已创建"),
    COMPLETED(3,"已完成"),
    OTHER(4,"未知状态");

    private final Integer code;
    private final String info;
}
