package com.mall.www.entity;

import java.util.Date;
import lombok.Data;

@Data
public class StockOut {
    /**
     * 主键,出库id
     */
    private Long stockOutId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 出库数量
     */
    private Integer quantity;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 出库时间
     */
    private Date time;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

