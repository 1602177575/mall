package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.entity.ReturnOrder;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.ReturnOrderMapper;
import com.mall.www.service.ReturnOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {
    @Resource
    ReturnOrderMapper returnOrderMapper;

    /**
     * 根据用户id获取退货订单列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<ReturnOrder> list(Long userId) {
        List<ReturnOrder> returnOrderList = null;
        try {
            returnOrderList = returnOrderMapper.selectListByUserId(userId);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return returnOrderList;
        }
    }
}
