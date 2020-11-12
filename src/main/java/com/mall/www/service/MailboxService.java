package com.mall.www.service;

import com.mall.www.entity.Mailbox;

import java.util.List;

public interface MailboxService {
    public static final int ZERO = 0;
    public static final int ONE = 1;

    /**
     * 根据用户id查询邮箱信息
     *
     * @param userId 用户id
     * @return
     */
    List<Mailbox> list(Long userId);

    /**
     * 修改邮箱的状态 收件箱->垃圾箱
     *
     * @param userId     用户id
     * @param mailboxIds 邮箱id
     * @param status     状态
     * @return
     */
    List<Mailbox> update(Long userId, List<Long> mailboxIds, int status);

    /**
     * 删除邮箱
     *
     * @param userId     用户id
     * @param mailboxIds 邮箱id
     * @return
     */
    List<Mailbox> delete(Long userId, List<Long> mailboxIds);
}
