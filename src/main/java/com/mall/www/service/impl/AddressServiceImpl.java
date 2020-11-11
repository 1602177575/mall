package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.dto.AddressDto;
import com.mall.www.entity.Address;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.AddressMapper;
import com.mall.www.service.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;

    /**
     * 根据用户Id查询用户的地址列表
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<Address> list(Long userId) {
        List<Address> addresses = null;
        try {
            addresses = addressMapper.selectList(userId);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return addresses;
        }
    }

    /**
     * 添加地址信息
     *
     * @param addressDto
     * @return
     */
    @Transactional
    @Override
    public List<Address> add(AddressDto addressDto) {
        try {
            Address address = new Address();
            BeanUtils.copyProperties(addressDto, address);
            int i = addressMapper.insert(address);
            if (i <= 0) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list(addressDto.getUserId());
        }
    }

    /**
     * 修改地址信息
     *
     * @param addressDto
     * @return
     */
    @Transactional
    @Override
    public List<Address> update(AddressDto addressDto) {
        try {
            Address address = new Address();
            BeanUtils.copyProperties(addressDto, address);
            int i = addressMapper.update(address);
            if (i <= 0) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list(addressDto.getUserId());
        }
    }

    /**
     * 根据地址id删除地址信息
     *
     * @param addressId
     * @return
     */
    @Transactional
    @Override
    public List<Address> delete(Long addressId) {
        List<Address> addresses = null;
        try {
            Address address = addressMapper.selectById(addressId);
            addresses = list(address.getUserId());
            int i = addressMapper.delete(addressId);
            if (i <= 0) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return addresses;
        }
    }
}
