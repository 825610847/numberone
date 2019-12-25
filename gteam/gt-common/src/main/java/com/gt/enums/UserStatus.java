package com.gt.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {
    BANNED(0, "封禁"),
    NORMAL(1, "正常"),
    DELETED(2, "已注销"),
    OTHER(3,"未知状态");

    private final Integer code;
    private final String info;
}
