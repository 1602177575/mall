package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.ReturnOrderDto;
import com.mall.www.service.ReturnOrderService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 申请退货
     *
     * @param returnOrderDto
     * @return
     */
    @PostMapping("/apply")
    public ResponseEntity apply(@RequestBody ReturnOrderDto returnOrderDto) {
        return ResponseEntity.success(returnOrderService.create(returnOrderDto));
    }
}
