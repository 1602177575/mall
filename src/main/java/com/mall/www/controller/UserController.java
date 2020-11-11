package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.ProductCommentsDto;
import com.mall.www.common.vo.ProductCommentsVo;
import com.mall.www.common.vo.UserCommentsVo;
import com.mall.www.entity.User;
import com.mall.www.service.ProductCommentsService;
import com.mall.www.service.UserCommentsService;
import com.mall.www.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    public boolean login(@RequestParam(required = true) String name,@RequestParam(required = true)  String password){
        boolean login = userService.login(name, password);
        return login;
    }

    /**
     * 用户注册
     * @param name
     * @param password
     * @param email
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<Integer> register(@RequestParam(required = true) String name, @RequestParam(required = true) String password, @RequestParam(required = true) String email){
        User user = new User(name,password,email);
       return ResponseEntity.success(userService.registerUser(user));
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
    public ResponseEntity<Integer> upPassword(@RequestParam(required = true) String name,@RequestParam(required = true)String password,@RequestParam(required = true)String newPwd){
        return ResponseEntity.success(userService.upPassword(name,password,newPwd));
    }

    /**
     * 查询所有的评价
     * @param uid
     * @return
     */
    @PostMapping("/userComments")
    public ResponseEntity<List<UserCommentsVo>> selectUserCommentsByUid(@RequestParam(required = true)Integer uid){
        return ResponseEntity.success(userCommentsService.selectUserCommentsByUser(uid));
    }

    /**
     * 查询用户的所有商品咨询
     * @param uid
     * @return
     */
    public ResponseEntity<List<ProductCommentsVo>> selectProCommentsByUid(@RequestParam(required = true)Integer uid){
        return ResponseEntity.success(productCommentsService.selectProductCommentsByUid(uid));
    }


}
