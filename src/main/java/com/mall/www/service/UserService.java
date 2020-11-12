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
    Integer registerUser(String name,String password,String email);


    /**
     * 删除用户
     * @param uid
     * @return
     */
    Integer deleteUser(Integer uid);


    /**
     * 修改密码
     * @param name 账号
     * @param password 旧密码
     * @param newPwd 新密码
     * @return
     */
    Integer upPassword(String name,String password,String newPwd);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer upDateUser(User user);

    /**
     *
     * @param email 用户邮箱
     * @param newPwd 用户新密码
     * @return
     */
    Integer EmailUpPassword(String email,String newPwd);


    /**
     * 判断邮箱是否存在
     * @param email
     * @return 存在返回1  不存在返回0
     */
    Integer isEmailExist(String email);

}
