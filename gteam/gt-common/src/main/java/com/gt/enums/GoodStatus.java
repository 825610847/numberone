package com.gt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum GoodStatus {
    ONSALE(0, "已上架"),
    SOLD(1, "已售出"),
    REMOVED(2, "已下架"),
    OTHER(3,"未知状态");

    private final Integer code;
    private final String info;
}
