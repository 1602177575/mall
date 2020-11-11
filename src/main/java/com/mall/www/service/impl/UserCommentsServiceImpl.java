package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.dto.UserCommentsDto;
import com.mall.www.common.vo.UserCommentsVo;
import com.mall.www.entity.UserComments;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.UserCommentsMapper;
import com.mall.www.service.UserCommentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserCommentsServiceImpl implements UserCommentsService {
    @Resource
    UserCommentsMapper mapper;

    @Override
    public List<UserCommentsVo> selectUserCommentsByUser(Integer userId) {
        List<UserCommentsVo> list = new ArrayList<>();
        try {
            List<UserComments> uc = mapper.selectCom(userId);
            uc.forEach(com -> {
                UserCommentsVo vo = new UserCommentsVo();
                vo.setAnswer(com.getAnswer());
                vo.setCommentsTime(com.getCommentsTime());
                vo.setComment(com.getComment());
                vo.setEvaluate(com.getEvaluate());
                list.add(vo);
            });
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list;
        }
    }

    @Override
    public List<UserCommentsVo> selectUserCommentsByPro(Long pid) {
        List<UserCommentsVo> list = new ArrayList<>();
        try {
            List<UserComments> userComments = mapper.selectUserCommentsByPro(pid);
            BeanUtils.copyProperties(userComments, list);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list;
        }
    }

    @Override
    public Integer insertUserComments(UserCommentsDto userCommentsDto) {
        Integer integer = 0;
        UserComments userComments = new UserComments();
        try {
            BeanUtils.copyProperties(userCommentsDto, userComments);
            integer = mapper.insertUserComments(userComments);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return integer;
        }

    }
}
