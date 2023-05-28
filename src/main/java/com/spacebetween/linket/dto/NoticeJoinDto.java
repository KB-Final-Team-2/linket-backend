package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class NoticeJoinDto {
    private Long noticeId;
    private Long noticeEventId;
    private Long noticeCompanyId;
    private String noticeTitle;
    private String noticeContent;
    private String regDate;
    private LocalDateTime lastUpdatedDate;

    public NoticeJoinDto(){}

    public NoticeJoinDto(Long noticeId, Long noticeEventId, Long noticeCompanyId, String noticeTitle, String noticeContent, String regDate, LocalDateTime lastUpdatedDate) {
        this.noticeId = noticeId;
        this.noticeEventId = noticeEventId;
        this.noticeCompanyId = noticeCompanyId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.regDate = regDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public Long getNoticeEventId() {
        return noticeEventId;
    }

    public void setNoticeEventId(Long noticeEventId) {
        this.noticeEventId = noticeEventId;
    }

    public Long getNoticeCompanyId() {
        return noticeCompanyId;
    }

    public void setNoticeCompanyId(Long noticeCompanyId) {
        this.noticeCompanyId = noticeCompanyId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public String toString() {
        return "NoticeJoinDto{" +
                "noticeId=" + noticeId +
                ", eventId=" + noticeEventId +
                ", companyId=" + noticeCompanyId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", regDate='" + regDate + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}
