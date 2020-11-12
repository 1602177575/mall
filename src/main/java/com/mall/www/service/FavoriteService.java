package com.mall.www.service;

import com.mall.www.common.bo.FavoriteBo;
import com.mall.www.common.vo.FavoriteVo;

import java.util.List;

public interface FavoriteService {



    /**
     * 根据用户ID 查询用户收藏的商品表
     * @param uid
     * @return
     */
    List<FavoriteVo> selectFavoriteByUid(Integer uid);

    /**
     * 添加收藏
     * @param uid 用户ID
     * @param pid 商品id
     * @return
     */
    Integer insertFavorite(Integer uid,Long pid);


    /**
     * 将收藏信息删除
     * @param tid 收藏类ID
     * @return
     */
    Integer deleteFavorite(List<Integer> tid);


    /**
     * 判断用户是否收藏过该商品
     * @param uid
     * @param pid
     * @return
     */
    Integer isFavoriteExist(Integer uid,Long pid);
}
