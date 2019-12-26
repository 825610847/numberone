package com.gt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * 通用PO父类
 * @author 李源仑
 */
@Data
@Accessors(chain=true)
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**创建时间*/
    private Date createTime;
    /**更新时间*/
    private Date updateTime;
}
