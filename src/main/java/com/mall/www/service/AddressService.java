package com.mall.www.service;

import com.mall.www.common.dto.AddressDto;
import com.mall.www.entity.Address;

import java.util.List;

public interface AddressService {
    /**
     * 根据用户Id查询用户的地址列表
     *
     * @param userId 用户id
     * @return
     */
    List<Address> list(Long userId);

    /**
     * 添加地址信息
     *
     * @param addressDto
     * @return
     */
    List<Address> add(AddressDto addressDto);

    /**
     * 修改地址信息
     *
     * @param addressDto
     * @return
     */
    List<Address> update(AddressDto addressDto);

    /**
     * 根据地址id删除地址信息
     *
     * @param addressId
     * @return
     */
    List<Address> delete(Long addressId);
}
