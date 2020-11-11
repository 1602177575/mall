package com.mall.www.controller;


import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.ProductCommentsDto;
import com.mall.www.common.dto.UserCommentsDto;
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
    @PostMapping("/userComments")
    public ResponseEntity<List<UserCommentsVo>> selectUserCommentsByPid(Integer uid){
        return ResponseEntity.success(userCommentsService.selectUserCommentsByUser(uid));
    }

    /**
     * 根据商品ID 查询该商品的商品咨询
     * @param pid
     * @return
     */
    @PostMapping("/productComments")
    public ResponseEntity<List<ProductCommentsVo>> selectProCommentsByPid(Long pid){
        return ResponseEntity.success(productCommentsService.selectProductCommentsByPro(pid));
    }


    /**
     * 根据用户ID 和商品ID 咨询内容
     * 创建商品咨询
     * @param productCommentsDto
     * @return
     */
    @PostMapping("/proComments")
    public ResponseEntity<Integer> insertProComments(ProductCommentsDto productCommentsDto){
        return ResponseEntity.success(productCommentsService.insertProductComments(productCommentsDto));
    }


    /**
     * 根据用户ID 和商品ID 评价内容
     * 创建用户对商品的评价
     * @param userCommentsDto
     * @return
     */
    @PostMapping("/userComments")
    public ResponseEntity<Integer> insertUserComments(UserCommentsDto userCommentsDto){
        return ResponseEntity.success(userCommentsService.insertUserComments(userCommentsDto));
    }


}
