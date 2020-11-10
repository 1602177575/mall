package com.mall.www.mapper;

import com.mall.www.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    /**
     * 判断用户账号密码
     * @param name
     * @param password
     * @return
     */
    Integer login(@Param("name") String name,@Param("pwd") String password);


    /**
     * 增加用户
     * @param user
     * @return
     */
    Integer addUser(@Param("user") User user);

    /**
     * 修改密码
     * @param name
     * @param password
     * @return
     */
    Integer upPassword(@Param("name") String name,@Param("pwd") String password);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Integer upDateUser(@Param("user")User user);
}
