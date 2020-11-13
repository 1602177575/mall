package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.bo.ScrollBarBo;
import com.mall.www.common.utils.ColaBeanUtils;
import com.mall.www.common.vo.ScrollBarVo;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.ScrollBarMapper;
import com.mall.www.service.ScrollBarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrollBarServiceImpl implements ScrollBarService {

    @Resource
    ScrollBarMapper scrollBarMapper;
    @Override
    public List<ScrollBarVo> selectScrollBar(Integer value) {
        List<ScrollBarBo> bos=null;
        List<ScrollBarVo> list=new ArrayList<>();
        try {
            bos = scrollBarMapper.selectScrollBar(value);
            list=ColaBeanUtils.copyListProperties(bos,ScrollBarVo::new);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return list;
    }

    @Override
    public Integer insertScrollBar(ScrollBarBo scrollBarBo) {
        Integer integer =0;
        try {
            integer=scrollBarMapper.insertScrollBar(scrollBarBo);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return integer;
    }

    @Override
    public Integer deleteScrollBar(Integer id) {
        Integer integer =0;
        try {
            integer=scrollBarMapper.deleteScrollBar(id);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }
        return integer;
    }
}
