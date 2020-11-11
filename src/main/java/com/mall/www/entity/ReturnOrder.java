package com.mall.www.entity;

import java.util.Date;
import lombok.Data;

@Data
public class ReturnOrder {
    /**
     * 主键
     */
    private Long returnOrderId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long orderId;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 退款类型
     */
    private String refundType;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 状态：0->待审,1->已完成,2->审核不通过
     */
    private Integer status;

    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
}

