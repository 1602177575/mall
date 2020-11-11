package com.mall.www.service;

import com.mall.www.common.dto.ProductCommentsDto;
import com.mall.www.common.vo.ProductCommentsVo;
import com.mall.www.entity.ProductComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCommentsService {

    /**
     * 根据商品ID查询 商品咨询表
     * @param pid
     * @return
     */
    List<ProductCommentsVo> selectProductCommentsByPro(Long pid);



    /**
     * 根据用户ID查询 商品咨询表
     * @param uid
     * @return
     */
    List<ProductCommentsVo> selectProductCommentsByUid(Integer uid);




    /**
     * 新增对商品的咨询 用户提问
     * @param productCommentsDto
     * @return
     */
    Integer insertProductComments(ProductCommentsDto productCommentsDto);



    /**
     * 商家答复
     * @param mid 评论ID
     * @param answer 商家答复
     * @return
     */
    Integer updateAnswer(Integer mid,String answer);
}
