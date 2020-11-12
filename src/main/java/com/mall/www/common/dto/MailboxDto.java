package com.mall.www.common.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Data
public class MailboxDto {
    Long userId;
    List<Long> mailboxIds;
}
