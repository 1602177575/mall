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
 * 创建订单     点击提交订单
 * 支付成功之后
 * 查询用户的订单
 * 删除订单
 * 查看订单详情
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

    /**
     * 根据用户id查询订单列表信息
     *
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity list(Long userId) {
        return ResponseEntity.success(orderService.list(userId));
    }

    /**
     * 根据订单id删除订单信息
     *
     * @param orderId 订单id
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity delete(Long orderId) {
        return ResponseEntity.success(orderService.delete(orderId));
    }

    /**
     * 根据订单id查订单信息
     *
     * @param orderId 订单id
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity get(Long orderId) {
        return ResponseEntity.success(orderService.getOrder(orderId));
    }
}
