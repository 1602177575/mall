package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.AddressDto;
import com.mall.www.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    AddressService addressService;

    /**
     * 查询用户的地址列表
     *
     * @param userId
     * @return
     */
    @GetMapping("list")
    public ResponseEntity list(Long userId) {
        return ResponseEntity.success(addressService.list(userId));
    }

    /**
     * 添加地址信息
     *
     * @param addressDto
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody AddressDto addressDto) {
        return ResponseEntity.success(addressService.add(addressDto));
    }

    /**
     * 修改地址信息
     *
     * @param addressDto
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody AddressDto addressDto) {
        return ResponseEntity.success(addressService.update(addressDto));
    }

    /**
     * 删除地址信息
     *
     * @param addressId
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity delete(Long addressId) {
        return ResponseEntity.success(addressService.delete(addressId));
    }

}
