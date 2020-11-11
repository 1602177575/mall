package com.mall.www.mapper;

import com.mall.www.entity.ProductComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCommentsMapper {


    /**
     * 根据商品ID查询 商品咨询表
     * @param pid
     * @return
     */
    List<ProductComments> selectProductCommentsByPro(@Param("pid") Long pid);


    /**
     * 根据用户ID查询 商品咨询表
     * @param uid
     * @return
     */
    List<ProductComments> selectProductCommentsByUid(@Param("uid") Integer uid);


    /**
     * 新增对商品的咨询 用户提问
     * @param productComments
     * @return
     */
    Integer insertProductComments(@Param("pc") ProductComments productComments);


    /**
     * 商家答复
     * @param mid 评论ID
     * @param answer 商家答复
     * @return
     */
    Integer updateAnswer(@Param("mid") Integer mid,@Param("as") String answer);
}
