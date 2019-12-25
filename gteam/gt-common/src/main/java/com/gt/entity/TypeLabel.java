package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类型标签PO
 * @author 李源仑
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeLabel extends BaseEntity {
    /**标签ID*/
    private Long labelId;
    /**商品ID*/
    private Long goodId;
    /**标签*/
    private String labelContent;
}
