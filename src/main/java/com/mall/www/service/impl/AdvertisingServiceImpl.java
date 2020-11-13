package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.bo.AdvertisingBo;
import com.mall.www.common.dto.AdvertisingDto;
import com.mall.www.common.utils.ColaBeanUtils;
import com.mall.www.common.vo.AdvertisingVo;
import com.mall.www.common.vo.ProductVo;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.AdvertisingMapper;
import com.mall.www.service.AdvertisingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Resource
    AdvertisingMapper advertisingMapper;

    @Override
    public List<ProductVo> selectScrollBar(Integer value) {
        return null;
    }

    @Override
    public List<AdvertisingVo> selectAdvertising(Integer value) {
        List<AdvertisingBo> bos=null;
        List<AdvertisingVo> list=new ArrayList<>();
        try {
            bos = advertisingMapper.selectAdvertising(value);
            System.out.println(bos);
            list = ColaBeanUtils.copyListProperties(bos, AdvertisingVo::new);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return list;
    }

    @Override
    public Integer insertStatusAdvertising(AdvertisingDto advertisingDto) {
        Integer save=0;
        try {
            save=advertisingMapper.insertAdvertising(advertisingDto);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return save;
    }

    @Override
    public Integer deleteAdvertising(Integer advertisingId) {
        Integer save=0;
        try {
            save=advertisingMapper.deleteAdvertising(advertisingId);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return save;
    }
}
