package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.bo.FavoriteBo;
import com.mall.www.common.vo.FavoriteVo;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.FavoriteMapper;
import com.mall.www.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    FavoriteMapper favoriteMapper;

    @Override
    public List<FavoriteVo> selectFavoriteByUid(Integer uid) {
        List<FavoriteBo> bo=null;
        List<FavoriteVo> list=new ArrayList<>();
        try {
                 bo  = favoriteMapper.selectFavoriteByUid(uid);
            bo.forEach(fb->{
                 FavoriteVo vo = new FavoriteVo();
                 vo.setId(fb.getId());
                 vo.setProductId(fb.getPid());
                 vo.setUid(fb.getUid());
                 vo.setIsStatus(fb.getIsStatus());
                 vo.setProduct(fb.getProduct());
                list.add(vo);
             });
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return list;
        }
    }

    @Override
    public Integer  insertFavorite(Integer uid, Long pid) {
        Integer integer=0;
        try {
            if(favoriteMapper.isFavoriteExist(uid,pid)==0){
                //收藏夹中已经由该商品 无需重复收藏
                return integer;
            }
            integer= favoriteMapper.insertFavorite(uid, pid);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }
        return integer;
    }

    @Override
    public Integer deleteFavorite(List<Integer> tid) {
        Integer integer=0;
        try {
            integer= favoriteMapper.deleteFavorite(tid);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }
        return integer;
    }

    @Override
    public Integer isFavoriteExist(Integer uid, Long pid) {
        Integer integer=0;
        try {
            integer= favoriteMapper.isFavoriteExist(uid,pid);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }
        return integer;
    }
}
