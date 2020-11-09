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
}
