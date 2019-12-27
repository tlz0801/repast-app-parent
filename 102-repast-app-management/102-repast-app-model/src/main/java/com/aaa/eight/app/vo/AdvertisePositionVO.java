package com.aaa.eight.app.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告位置表和广告表的VO合并实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdvertisePositionVO implements Serializable {

    private Long id;
    /**
     * 业务类型，餐饮小程序0
     */
    private Integer type;

    /**
     * 广告位置名称
     */
    private String addrName;

    /**
     * 广告位置名称
     */
    private String descrition;

    /**
     * 该位置最多几个广告
     */

    private Integer maxCount;


    private Long shopId;

    private String advertiseName;

    /**
     * 轮播位置
     */

    private Long positionId;

    private String pic;


    private Date startTime;


    private Date endTime;

    /**
     * 上下线状态：0->下线；1->上线
     */
    private Integer status;

    /**
     * 点击数
     */

    private Integer clickCount;

    /**
     * 下单数
     */

    private Integer orderCount;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 备注
     */
    private String note;

    /**
     * 排序
     */
    private Integer sort;

}
