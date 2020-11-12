package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.service.EmailService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 邮箱找回密码修改密码
 *
 * 发送验证码
 *
 * 输入正确的验证码以及邮箱 新密码
 */
@RestController
public class EmailController {

    @Resource
    EmailService emailService;

    /**
     * 输入邮箱 发送验证码
     * @param mailIndex 邮箱地址
     * @return  发送失败返回0  成功则返回1
     */
    @RequestMapping("/email")
    public ResponseEntity<Integer> SendEmail(@RequestParam(value = "mailIndex")String mailIndex) throws EmailException {
       return   ResponseEntity.success(emailService.getEmailService(mailIndex));

    }


    /**
     *
     * @param verify 验证码
     * @param email 用户发送的邮箱
     * @param newPwd 新密码
     * @return 返回0则验证码错误 返回1则正确则修改密码
     */
    @PostMapping("/code")
    public ResponseEntity<Integer> SecurityCode(@RequestParam(value = "verify") Integer verify,
                                                @RequestParam(value = "email") String email,
                                                @RequestParam(value = "newPwd")String newPwd){
        return ResponseEntity.success(emailService.getSecurityCode(verify,email,newPwd));
    }


}
