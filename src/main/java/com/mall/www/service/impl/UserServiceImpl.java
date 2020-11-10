package com.mall.www.service.impl;

import com.mall.www.entity.User;
import com.mall.www.mapper.UserMapper;
import com.mall.www.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public boolean login(String name, String password) {
        boolean save =false;
        Integer login = userMapper.login(name, password);
        if(login!=null){
            save=true;
        }
        return save;
    }

    @Override
    public Integer registerUser(User user) {
        Integer integer = userMapper.addUser(user);
        return integer;
    }

    @Override
    public Integer deleteUser(Integer uid) {
        return null;
    }

    @Override
    public Integer upPassword(String name, String password) {
        Integer integer = userMapper.upPassword(name, password);
        return integer;
    }

    @Override
    public Integer upDateUser(User user) {
        Integer integer = userMapper.upDateUser(user);
        return integer;
    }
}
