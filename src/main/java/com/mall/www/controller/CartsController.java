package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.CartsDto;
import com.mall.www.common.vo.CartsVo;
import com.mall.www.service.CartsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车
 * 查看购物车
 * 更新购物车   添加、修改购物数量
 * 删除购物    删除一个或者多个购物车信息
 */
@RestController
@RequestMapping("/carts")
public class CartsController {
    @Resource
    private CartsService cartsService;

    /***
     *  获取购物信息
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<CartsVo>> list(@RequestParam Long userId) {
        return ResponseEntity.success(cartsService.list(userId));
    }

    /**
     * 更新购物车信息
     *
     * @param cartsDto
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<List<CartsVo>> update(@RequestBody CartsDto cartsDto) {
        return ResponseEntity.success(cartsService.updateProductQuantity(cartsDto));
    }

    /**
     * 跟局购物车id删除购物车信息
     *
     * @param cartIds 购物车集合
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity<Integer> delete(@RequestParam List<Long> cartIds) {
        return ResponseEntity.success(cartsService.deleteCarts(cartIds));
    }
}
