package com.mall.www.mapper;

import com.mall.www.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    /**
     * 根据用户id查询地址信息
     * @param userId    用户id
     * @return  地址信息集合
     */
    List<Address> selectList(@Param("userId") Long userId);

    /**
     *  根据地址id查询地址信息
     * @param addressId 地址id
     * @return
     */
    Address selectById(@Param("addressId") Long addressId);
}
