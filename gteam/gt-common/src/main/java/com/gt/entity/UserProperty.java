package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户信息PO
 * @author 李源仑
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProperty extends BaseEntity{
    /**用户ID*/
    private Long userId;
    /**用户真实姓名*/
    private String userName;
    /**用户登录名*/
    private String userLoginName;
    /**用户性别*/
    private String userGender;
    /**用户年龄*/
    private Integer userAge;
    /**用户手机号码*/
    private String userPhoneNumber;
    /**用户邮箱*/
    private String userEmail;
    /**钱包余额*/
    private Double userWallet;
    /**用户状态*/
    private Integer userStatus;
}
