package com.mall.www.service;

import com.mall.www.common.dto.UserCommentsDto;
import com.mall.www.common.vo.UserCommentsVo;
import com.mall.www.entity.UserComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCommentsService {

    /**
     * 查询该用户的所有评价
     * @param uid
     * @return
     */
    List<UserCommentsVo> selectUserCommentsByUser(Integer uid);


    /**
     * 查询商品下 各用户的对其评价
     * @param pid
     * @return
     */
    List<UserCommentsVo> selectUserCommentsByPro(Long pid);


    /**
     * 新增评论
     * @param userComments
     * @return
     */
    Integer insertUserComments(UserCommentsDto userCommentsDto);

}
