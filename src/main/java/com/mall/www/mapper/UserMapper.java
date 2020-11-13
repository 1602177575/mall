package com.mall.www.mapper;

import com.mall.www.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    /**
     * 判断用户账号密码
     *
     * @param name
     * @param password
     * @return
     */
    Integer login(@Param("name") String name, @Param("pwd") String password);


    /**
     * 增加用户
     *
     * @param name     账号
     * @param password ，密码
     * @param email    邮箱
     * @return
     */
    Integer addUser(@Param("name") String name, @Param("pwd") String password, @Param("em") String email);

    /**
     * 修改密码
     *
     * @param name     账号
     * @param password 旧密码
     * @param newPwd   新密码
     * @return
     */
    Integer upPassword(@Param("name") String name, @Param("pwd") String password, @Param("newPwd") String newPwd);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    Integer upDateUser(@Param("upUser") User user);


    /**
     * 用户通过邮箱验证码 修改密码
     *
     * @param email
     * @param newPwd
     * @return
     */
    Integer upPasswordByEmail(@Param("email") String email, @Param("newPwd") String newPwd);


    /**
     * 判断邮箱是否存在
     *
     * @param email
     * @return
     */
    Integer isEmailExist(@Param("email") String email);


    User selectByUserId(@Param("userId") Long userId);
}
