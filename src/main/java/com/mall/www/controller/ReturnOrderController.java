package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.service.ReturnOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/refund")
public class ReturnOrderController {
    @Resource
    ReturnOrderService returnOrderService;

    /**
     * 查询用户的退货订单
     *
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity list(Long userId) {
        return ResponseEntity.success(returnOrderService.list(userId));
    }
}
