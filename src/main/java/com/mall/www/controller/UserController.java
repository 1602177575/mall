package com.mall.www.controller;

import com.mall.www.entity.User;
import com.mall.www.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

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
    public Integer register(String name,String password,String email){
        User user = new User(name,password,email);
        Integer integer = userService.registerUser(user);
        return integer;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public Integer upDateUser(User user){
        Integer integer = userService.upDateUser(user);
        return integer;
    }
}
