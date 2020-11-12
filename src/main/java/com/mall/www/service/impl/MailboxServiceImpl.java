package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.entity.Mailbox;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.MailboxMapper;
import com.mall.www.service.MailboxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MailboxServiceImpl implements MailboxService {

    @Resource
    MailboxMapper mailboxMapper;

    /**
     * 根据用户id查询邮箱信息
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<Mailbox> list(Long userId) {
        List<Mailbox> mailboxes = null;
        try {
            mailboxes = mailboxMapper.selectListByUserId(userId);
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return mailboxes;
        }
    }


    /**
     * 修改邮箱的状态 收件箱->垃圾箱
     *
     * @param mailboxIds
     * @return
     */
    @Transactional
    @Override
    public List<Mailbox> update(Long userId, List<Long> mailboxIds, int status) {
        try {
            int i = mailboxMapper.updateMailboxStatus(mailboxIds, status);
            if (i <= 0) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list(userId);
        }
    }

    /**
     * 删除邮箱
     *
     * @param userId     用户id
     * @param mailboxIds 邮箱id
     * @return
     */
    @Override
    public List<Mailbox> delete(Long userId, List<Long> mailboxIds) {
        try {
            int i = mailboxMapper.delete(mailboxIds);
            if (i <= 0) {
                throw new ServiceException(StatusCode.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new ServiceException(StatusCode.SERVER_ERROR);
        } finally {
            return list(userId);
        }
    }
}
