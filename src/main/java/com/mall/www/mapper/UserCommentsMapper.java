package com.mall.www.mapper;

import com.mall.www.entity.UserComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserCommentsMapper {


    /**
     * 查询用户的所有评价
     * @param uid
     * @return
     */
    List<UserComments> selectCom(@Param("uid") Integer uid);


    /**
     * 查询商品下 各用户的对其评价
     * @param pid
     * @return
     */
    List<UserComments> selectUserCommentsByPro(@Param("pid") Long pid);


    /**
     * 新增评论
     * @param userComments
     * @return
     */
    Integer insertUserComments(@Param("uc")UserComments userComments);


}

