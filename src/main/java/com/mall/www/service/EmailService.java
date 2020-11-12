package com.mall.www.service;

import org.apache.commons.mail.EmailException;

public interface EmailService {


    /**
     * 发送邮箱验证码
     * @param mailIndex 邮箱地址
     * @return
     */
    public Integer getEmailService(String mailIndex) throws EmailException;


    /**
     * 验证输入的验证码
     * 正确进入修改密码界面 错误则提示
     * @param details
     * @return
     */
    public Integer getSecurityCode(Integer details,String Email,String newPwd);

}
