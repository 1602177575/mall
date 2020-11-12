package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.exception.ServiceException;
import com.mall.www.service.EmailService;
import com.mall.www.service.UserService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;
import java.rmi.ServerError;
import java.util.Random;


@Service
public class EmailServiceImpl implements EmailService {
    public static  Random ran=new Random();
    //取值范围为四位数
    public final static int num=ran.nextInt(90000)+9999;

    @Resource
    UserService userService;

    /**
     *
     * @param mailIndex 邮箱地址
     * @return
     */
    @Override
    public Integer getEmailService(String mailIndex){
        Integer result=0;
        try {
            HtmlEmail htmlEmail=new HtmlEmail();
            htmlEmail.setHostName("smtp.qq.com");//qq邮箱的SMTP服务器地址
            htmlEmail.setCharset("utf-8");
            htmlEmail.addTo(mailIndex);//目标邮箱地址
            htmlEmail.setFrom("1602177575@qq.com","验证码请查收");//你的邮箱地址
            htmlEmail.setAuthentication("1602177575@qq.com","njvwydxyeuvobaea");//你的邮箱地址和你的stmp密码
            htmlEmail.setTextMsg("测试验证码");
            htmlEmail.setMsg(String.valueOf(num));//内容最好不要太简单了，不然容易进垃圾邮箱
            htmlEmail.send(); //发送
            result=1;
        }catch (EmailException e){
            //邮箱错误
            throw new ServiceException(StatusCode.EMAIL_ERROR);
        }catch (Exception e){
            //系统错误
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }
        return result;
    }

    /**
     *
     * @param details 验证码
     *
     * @return 返回0则验证码错误 返回1正确 则修改新密码
     */
    @Override
    public Integer getSecurityCode(Integer details, String email, String newPwd) {
        Integer save = 0;
        try {
            Integer exist = userService.isEmailExist(email);
            if (exist == 0) {
                //邮箱不存在
                return save;
            } else if (details == num) {
                //如验证码正确则修改账号密码
                userService.EmailUpPassword(email, newPwd);
                save = 1;
            }
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }

        return save;
    }
}
