package com.mall.www.controller;


import com.mall.www.common.ResponseEntity;
import com.mall.www.common.vo.DetailsProductVo;
import com.mall.www.common.vo.ProductCommentsVo;
import com.mall.www.common.vo.UserCommentsVo;
import com.mall.www.service.ProductCommentsService;
import com.mall.www.service.ProductService;
import com.mall.www.service.UserCommentsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductService productService;
    @Resource
    UserCommentsService userCommentsService;
    @Resource
    ProductCommentsService productCommentsService;

    /**
     * 展示商品详情
     * @param pid 商品ID
     * @return
     */
    @RequestMapping("/Details/{id}")
    public ResponseEntity<DetailsProductVo> selectProductDetails(@PathVariable(required = true , value = "id") Long pid){
        return ResponseEntity.success(productService.selectProductDetails(pid));
    }

    /**
     * 查看该商品的评论
     * @param uid
     * @return
     */
    @PostMapping("/UserComments")
    public ResponseEntity<List<UserCommentsVo>> selectUserCommentsByPid(Integer uid){
        return ResponseEntity.success(userCommentsService.selectUserCommentsByUser(uid));
    }

    /**
     * 根据商品ID 查询该商品的商品咨询
     * @param pid
     * @return
     */
    @PostMapping("/ProductComments")
    public ResponseEntity<List<ProductCommentsVo>> selectProCommentsByPid(Long pid){
        return ResponseEntity.success(productCommentsService.selectProductCommentsByPro(pid));
    }

}
