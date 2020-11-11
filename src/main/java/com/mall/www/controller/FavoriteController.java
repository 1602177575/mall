package com.mall.www.controller;


import com.mall.www.common.ResponseEntity;
import com.mall.www.common.bo.FavoriteBo;
import com.mall.www.common.vo.FavoriteVo;
import com.mall.www.service.FavoriteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品的收藏
 *
 *
 * 用户查看已经收藏的商品
 * 用户收藏商品
 * 用户删除收藏商品
 */

@RestController
@RequestMapping("/collection")
public class FavoriteController {

    @Resource
    FavoriteService collectionService;

    /**
     * 查看用户已经收藏的商品
     * @param uid 用户ID
     * @return
     */
    @PostMapping("/collectionGoods")
    public ResponseEntity<List<FavoriteVo>> selectCollectionByUid(Integer uid){
         return ResponseEntity.success(collectionService.selectFavoriteByUid(uid));
    }

    /**
     * 收藏商品
     * @param uid
     * @param pid
     * @return
     */
    @PostMapping("/insertCollection")
    public ResponseEntity<Integer> insertCollection(Integer uid,Long pid){
        return ResponseEntity.success(collectionService.insertFavorite(uid,pid));
    }

    /**
     * 删除收藏
     * @param tid
     * @return
     */
    @PostMapping("/deleteCollection")
    public ResponseEntity<Integer> deleteCollection(List<Integer> tid){
        return ResponseEntity.success(collectionService.deleteFavorite(tid));
    }

}
