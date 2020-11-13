package com.mall.www.mapper;

import com.mall.www.common.bo.AdvertisingBo;
import com.mall.www.common.dto.AdvertisingDto;
import com.mall.www.entity.Advertising;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdvertisingMapper {

    /**
     * 查询广告商品
     * @param value
     * @return
     */
    List<AdvertisingBo> selectAdvertising(@Param("value") Integer value);

    /**
     * 添加广告商品
     * @param advertisingDto
     * @return
     */
    Integer insertAdvertising(@Param("at") AdvertisingDto advertisingDto);

    /**
     * 删除广告商品
     * @param advertisingId
     * @return
     */
    Integer deleteAdvertising(@Param("atId") Integer advertisingId);



}