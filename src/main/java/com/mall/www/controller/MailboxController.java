package com.mall.www.controller;

import com.mall.www.common.ResponseEntity;
import com.mall.www.common.dto.MailboxDto;
import com.mall.www.entity.Mailbox;
import com.mall.www.service.MailboxService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/mailbox")
public class MailboxController {

    @Resource
    MailboxService mailboxService;

    /**
     * 查询用户的所有邮箱
     *
     * @param userId
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity list(Long userId) {
        return ResponseEntity.success(mailboxService.list(userId));
    }

    /**
     * 删除：收件箱->垃圾箱
     *
     * @param mailboxDto
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody MailboxDto mailboxDto) {
        return ResponseEntity.success(mailboxService.update(mailboxDto.getUserId(), mailboxDto.getMailboxIds(), MailboxService.ONE));
    }

    /**
     * 彻底删除
     *
     * @param mailboxDto
     * @return
     */
    @PostMapping("/completely")
    public ResponseEntity completelyDelete(@RequestBody MailboxDto mailboxDto) {
        return ResponseEntity.success(mailboxService.delete(mailboxDto.getUserId(), mailboxDto.getMailboxIds()));
    }

    /**
     * 还原 垃圾箱->收件箱
     *
     * @param mailboxDto
     * @return
     */
    @PostMapping("/restore")
    public ResponseEntity restore(@RequestBody MailboxDto mailboxDto) {
        return ResponseEntity.success(mailboxService.update(mailboxDto.getUserId(), mailboxDto.getMailboxIds(), MailboxService.ZERO));
    }
}
