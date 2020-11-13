package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.UserCommentsDto;
import com.mall.www.common.vo.ProductCommentsVo;
import com.mall.www.common.vo.UserCommentsVo;
import com.mall.www.entity.User;
import com.mall.www.service.ProductCommentsService;
import com.mall.www.service.UserCommentsService;
import com.mall.www.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户登陆判断
 * 注册
 * 修改信息
 * 修改密码
 * 查看用户的评价
 * 查看用户的商品咨询
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;
    @Resource
    UserCommentsService userCommentsService;
    @Resource
    ProductCommentsService productCommentsService;

    /**
     * 用户登陆判断
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam(required = true,value = "name") String name,
                                         @RequestParam(required = true,value = "password")  String password){
        return ResponseEntity.success(userService.login(name,password));
    }

    /**
     * 用户注册
     * @param name
     * @param password
     * @param email
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestParam(required = true) String name,
                                            @RequestParam(required = true) String password,
                                            @RequestParam(required = true) String email){
       return ResponseEntity.success(userService.registerUser(name,password,email));
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> upDateUser(@RequestParam(required = true) User user){
       return ResponseEntity.success(userService.upDateUser(user));
    }


    /**
     * 修改用户密码
     * @param name 用户名
     * @param password 用户新密码
     * @param newPwd 新密码
     * @return
     */
    @PostMapping("/upPassword")
    public ResponseEntity<Integer> upPassword(@RequestParam(required = true) String name,
                                              @RequestParam(required = true)String password,
                                              @RequestParam(required = true)String newPwd){
        return ResponseEntity.success(userService.upPassword(name,password,newPwd));
    }

    /**
     * 查询用户的所有的用户评价
     * @param uid
     * @return
     */
    @PostMapping("/userComments")
    public ResponseEntity<List<UserCommentsVo>> selectUserCommentsByUid(@RequestParam(required = true)Integer uid){
        return ResponseEntity.success(userCommentsService.selectUserCommentsByUser(uid));
    }



    /**
     * 根据用户ID 和商品ID  创建评价内容
     * 创建用户对商品的评价
     * @param userCommentsDto
     * @return
     */
    @PostMapping("/addUserComments")
    public ResponseEntity<Integer> insertUserComments(@RequestBody UserCommentsDto userCommentsDto){
        System.out.println(userCommentsDto.toString());
        return ResponseEntity.success(userCommentsService.insertUserComments(userCommentsDto));
    }


}
