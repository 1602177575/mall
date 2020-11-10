package com.mall.www.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Stock {
    /**
     * 主键,库存id
     */
    private Long stockId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Long total;

    /**
     * 预订数量
     */
    private Long reservation;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

