package com.mall.www.mapper;

import com.mall.www.common.bo.FavoriteBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper {

    /**
     * 根据用户ID 查询用户收藏的商品表
     * @param uid
     * @return
     */
    List<FavoriteBo> selectFavoriteByUid(@Param("uid") Integer uid);

    /**
     * 添加收藏
     * @param uid 用户ID
     * @param pid 商品id
     * @return
     */
    Integer insertFavorite(@Param("uid")Integer uid,@Param("pid")Long pid);


    /**
     * 将收藏信息删除
     * @param tid 收藏类ID集合
     * @return
     */
    Integer deleteFavorite(@Param("tid")List<Integer> tid);


    /**
     * 判断用户是否已经收藏过该商品
     * @param uid
     * @param pid
     * @return
     */
    Integer isFavoriteExist(@Param("uid") Integer uid,@Param("pid") Long pid);
}
