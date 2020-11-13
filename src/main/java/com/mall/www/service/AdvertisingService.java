package com.mall.www.service;

import com.mall.www.common.dto.AdvertisingDto;
import com.mall.www.common.vo.AdvertisingVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.entity.Advertising;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdvertisingService {

    /**
     * 展示广告滚动栏商品
     * @param value 展示前几条商品
     * @return
     */
    List<ProductVo> selectScrollBar(Integer value);


    /**
     * 展示广告位商品
     * 获取一定数量
     * @param value 展示前几条商品
     * @return
     */
    List<AdvertisingVo> selectAdvertising(Integer value);


    /**
     * 添加广告推荐
     *
     * @param
     * @return
     */
    Integer insertStatusAdvertising(AdvertisingDto advertisingDto);

    /**
     * 删除广告推荐
     * @param advertisingId
     * @return
     */
    Integer deleteAdvertising(Integer advertisingId);

}
