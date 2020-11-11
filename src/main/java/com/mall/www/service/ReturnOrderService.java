package com.mall.www.service;

import com.mall.www.entity.ReturnOrder;

import java.util.List;

public interface ReturnOrderService {
    /**
     * 根据用户id获取退货订单列表
     *
     * @param userId
     * @return
     */
    List<ReturnOrder> list(Long userId);
}
