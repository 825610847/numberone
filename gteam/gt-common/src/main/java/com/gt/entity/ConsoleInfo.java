package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 主机信息
 * @author 李源仑
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsoleInfo extends BaseEntity{
    /**主机ID*/
    private Long consoleId;
    /**主机名称*/
    private String consoleName;
    /**主机品牌*/
    private String consoleDeveloper;
    /**主机分区*/
    private String consoleZone;
    /**主机内存大小*/
    private Integer memorySize;
    /**主机硬盘储存大小*/
    private Integer storageSize;
    /**CPU规格*/
    private String cpuInfo;
    /**主机图片*/
    private String consoleImage;
    /**主机介绍*/
    private String consoleDescription;
}
