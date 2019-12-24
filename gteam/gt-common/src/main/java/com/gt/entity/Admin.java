package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员PO
 * @author 李源仑
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends BaseEntity{
    /**管理员ID*/
    private Long adminId;
    /**管理员登录名*/
    private String adminLoginName;
    /**管理员权限*/
    private Integer adminPermission;
    /**管理员状态*/
    private Integer adminStatus;
    /**管理员电话号码*/
    private String adminPhoneNumber;
}
