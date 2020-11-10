package com.mall.www.service;

import com.mall.www.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 登陆判断
     * @param name
     * @param password
     * @return
     */
    boolean login(String name,String password);


    /**
     * 注册用户
     * @param
     * @return
     */
    Integer registerUser(User user);


    /**
     * 删除用户
     * @param uid
     * @return
     */
    Integer deleteUser(Integer uid);



    Integer upPassword(String name,String password);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer upDateUser(User user);

}
