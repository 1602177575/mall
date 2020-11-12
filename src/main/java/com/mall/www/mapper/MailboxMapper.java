package com.mall.www.mapper;

import com.mall.www.entity.Mailbox;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface MailboxMapper {
    /**
     * 根据用户id查询邮箱信息
     *
     * @param userId
     * @return
     */
    List<Mailbox> selectListByUserId(@Param("userId") Long userId);

    /**
     * 根据邮箱id修改邮箱的状态
     *
     * @param mailboxIds
     * @return
     */
    int updateMailboxStatus(@Param("mailboxIds") List<Long> mailboxIds,@Param("status")int status);

    /**
     * 根据邮箱id删除邮箱信息
     * @param mailboxIds
     * @return
     */
    int delete(@Param("mailboxIds") List<Long> mailboxIds);
}
