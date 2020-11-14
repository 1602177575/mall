package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.exception.ServiceException;
import com.mall.www.service.EmailService;
import com.mall.www.service.UserService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;


@Service
public class EmailServiceImpl implements EmailService {
    public static  Random ran=new Random();
    //取值范围为四位数
    public final static int num=ran.nextInt(90000)+9999;
    public static String hintTop="您正在进行 找回密码操作 请在验证码输入框中输入";
    public static String hint="注意：此操作可能会修改您的密码、登录邮箱或绑定手机。如非本人操作，请及时登录并修改密码以保证帐户安全" +
            "(工作人员不会向你索取此验证码，请勿泄漏！)";
    public static String S_MTP="smtp.qq.com"; //qq邮箱的SMTP服务器地址
    public static String S_MTP_PWD=" //";  //你的stmp密码
    public static String SYSTEM_EMAIL="1602177575@qq.com"; //服务器邮箱

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
        //如果无此邮箱直接返回
        if(userService.isEmailExist(mailIndex.trim())==0){
            return 0;
        }
        try {
            HtmlEmail htmlEmail=new HtmlEmail();
            htmlEmail.setHostName(S_MTP);//qq邮箱的SMTP服务器地址
            htmlEmail.setCharset("utf-8");
            htmlEmail.addTo(mailIndex.trim());//目标邮箱地址
            htmlEmail.setFrom(SYSTEM_EMAIL,"验证码请查收");//你的邮箱地址
            htmlEmail.setAuthentication(SYSTEM_EMAIL,S_MTP_PWD);//你的邮箱地址和你的stmp密码
            htmlEmail.setTextMsg("测试验证码");
            htmlEmail.setMsg(hintTop+"<h2>"+String.valueOf(num)+"</h2>\n"+hint);//内容最好不要太简单了，不然容易进垃圾邮箱
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
