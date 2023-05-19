package com.spacebetween.linket.domain;

import java.time.LocalDateTime;

public class Notice {
    private Long noticeId;
    private Long eventId;
    private Long companyId;
    private String noticeTitle;
    private String noticeContent;
    private String regDate;
    private LocalDateTime lastUpdatedDate;
}
