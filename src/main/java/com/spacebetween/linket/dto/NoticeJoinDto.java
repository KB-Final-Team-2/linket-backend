package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class NoticeJoinDto {
    private Long noticeId;
    private Long eventId;
    private Long companyId;
    private String noticeTitle;
    private String noticeContent;
    private String regDate;
    private LocalDateTime lastUpdatedDate;

    public NoticeJoinDto(){}

    public NoticeJoinDto(Long noticeId, Long eventId, Long companyId, String noticeTitle, String noticeContent, String regDate, LocalDateTime lastUpdatedDate) {
        this.noticeId = noticeId;
        this.eventId = eventId;
        this.companyId = companyId;
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
                ", eventId=" + eventId +
                ", companyId=" + companyId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", regDate='" + regDate + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}
