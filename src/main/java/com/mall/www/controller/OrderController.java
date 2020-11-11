package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.OrderDto;
import com.mall.www.common.vo.OrderPrepareVo;
import com.mall.www.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单
 * <p>
 * 订单准备     结算页面
 * 需要用户id (查地址，优惠卷)
 * 需要商品：id、商品数量、单价、数量,名称（不用购物车id，是考虑用户不加入购物车直接购买）
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;

    /**
     * 订单准备     结算页面
     * 需要用户id (查地址，优惠卷)
     * 需要商品：id、商品数量、单价、数量,名称
     * （不用购物车id，是考虑用户不加入购物车直接购买）
     *
     * @param orderDto 用户id，商品id集合,及对象的商品数量
     * @return
     */
    @PostMapping("/prepare")
    public ResponseEntity<OrderPrepareVo> prepare(@RequestBody OrderDto orderDto) {
        return ResponseEntity.success(orderService.prepare(orderDto));
    }

    /***
     * 创建订单
     * @param orderDto
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody OrderDto orderDto) {
        return ResponseEntity.success(orderService.create(orderDto));
    }

    /**
     * 支付成功后根据订单id修改订单的状态
     *
     * @param orderId 订单id
     * @return
     */
    @PostMapping("/successful")
    public ResponseEntity paymentSuccessful(@RequestParam Long orderId) {
        return ResponseEntity.success(orderService.updatePaymentStatus(orderId));
    }
}
