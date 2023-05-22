package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class EventJoinDto {

    private Long eventId; // 행사 아이디 자동생성
    private Long companyId;
    private String eventName; // 행사명
    private String eventType; // 행사 종류
    private String place; // 행사 장소
    private String eventImage; // 행사 이미지
    private String eventInq; // 행사 대표문의처
    private String eventDesc; // 행사 설명
    private char eventStatus; // 진행 여부 (default: 'Y')
    private String startDate; // 행사 시작일자
    private String endDate; // 행사 종료일자
    private LocalDateTime regDate; // 등록일자
    private LocalDateTime lastUpdatedDate; // 수정일자
    private LocalDateTime deletedDate; // 삭제일자
    private String link; // 링크

    public EventJoinDto(Long eventId, Long companyId, String eventName, String eventType, String place, String eventImage, String eventInq, String eventDesc, char eventStatus, String startDate, String endDate, LocalDateTime regDate, LocalDateTime lastUpdatedDate, LocalDateTime deletedDate, String link) {
        this.eventId = eventId;
        this.companyId = companyId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.place = place;
        this.eventImage = eventImage;
        this.eventInq = eventInq;
        this.eventDesc = eventDesc;
        this.eventStatus = eventStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.regDate = regDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.deletedDate = deletedDate;
        this.link = link;
    }

    //register
    public EventJoinDto(Long companyId, String eventName, String eventType, String place, String eventInq, char eventStatus, String startDate, String endDate, LocalDateTime regDate, String link) {
        this.companyId = companyId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.place = place;
        this.eventInq = eventInq;
        this.eventStatus = eventStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.regDate = regDate;
        this.link = link;
    }

    // updateEvent()
    public EventJoinDto(Long eventId, String eventName, String eventType, String place, String eventImage, String eventInq, String eventDesc, String startDate, String endDate, LocalDateTime lastUpdatedDate, String link) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.place = place;
        this.eventImage = eventImage;
        this.eventInq = eventInq;
        this.eventDesc = eventDesc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.link = link;
    }
    //deleteEvent()
    public EventJoinDto(Long eventId, char eventStatus ,LocalDateTime lastUpdatedDate) {
        this.eventId = eventId;
        this.eventStatus = eventStatus;
        this.lastUpdatedDate = lastUpdatedDate;
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }

    public String getEventInq() {
        return eventInq;
    }

    public void setEventInq(String eventInq) {
        this.eventInq = eventInq;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public char getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(char eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getLink() { return link; }

    public void setLink(String link) {this.link = link;}

    @Override
    public String toString() {
        return "EventJoinDto{" +
                "eventId=" + eventId +
                ", companyId=" + companyId +
                ", eventName='" + eventName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", place='" + place + '\'' +
                ", eventImage='" + eventImage + '\'' +
                ", eventInq='" + eventInq + '\'' +
                ", eventDesc='" + eventDesc + '\'' +
                ", eventStatus=" + eventStatus +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", regDate=" + regDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", deletedDate=" + deletedDate +
                ", link='" + link + '\'' +
                '}';
    }
}
