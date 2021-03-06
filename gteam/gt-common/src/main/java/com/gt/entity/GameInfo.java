package com.gt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 游戏信息PO
 * @author 李源仑
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameInfo extends BaseEntity{
    /**游戏ID*/
    private Long gameId;
    /**游戏名称*/
    private String gameName;
    /**游戏类型组*/
    private String[] gameType;
    /**游戏厂商*/
    private String gameDeveloper;
    /**游戏支持平台组*/
    private String[] gamePlatform;
    /**游戏评分*/
    private Integer gameRating;
    /**游戏是否支持汉语*/
    private boolean isSupportChinese;
    /**游戏发布日期*/
    private Date gameReleaseDate;
    /**游戏图片*/
    private String gameImage;
    /**游戏介绍*/
    private String gameDescription;
}
