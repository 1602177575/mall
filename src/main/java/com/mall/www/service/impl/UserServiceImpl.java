package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.entity.User;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.UserMapper;
import com.mall.www.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public boolean login(String name, String password) {
        boolean save =false;
        try {
            Integer login = userMapper.login(name, password);
            if(login>0){
                save=true;
            }else {
                throw new ServiceException(StatusCode.PN_ERROR);
            }
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }finally {
            return save;
        }
    }

    @Override
    public Integer registerUser(String name,String password,String email) {
        Integer integer=0;
        try {
            integer = userMapper.addUser(name,password,email);
            if(integer==0){
                throw new ServiceException(StatusCode.REGISTER_ERROR);
            }
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }finally {
            return integer;
        }
    }

    @Override
    public Integer deleteUser(Integer uid) {
        return null;
    }

    @Override
    public Integer upPassword(String name, String password,String newPwd) {
        Integer integer=0;
        try {
            integer = userMapper.upPassword(name, password,newPwd);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }finally {
            return integer;
        }
    }

    @Override
    public Integer upDateUser(User user) {
        Integer integer=0;
        try {
            integer = userMapper.upDateUser(user);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }finally {
            return integer;
        }
    }

    @Override
    public Integer EmailUpPassword(String email, String newPwd) {
        Integer integer=0;
        try {
            integer = userMapper.upPasswordByEmail(email,newPwd);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }finally {
            return integer;
        }
    }


    @Override
    public Integer isEmailExist(String email) {
        Integer integer=0;
        try {
            integer = userMapper.isEmailExist(email);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SYS_ERROR);
        }finally {
            return integer;
        }
    }
}
