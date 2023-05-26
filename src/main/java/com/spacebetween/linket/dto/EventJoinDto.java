package com.spacebetween.linket.dto;

public class EventJoinDto {

    private Long eventId; // 행사 아이디 자동생성
    private Long companyId; // 기업 아이디
    private String eventName; // 행사명
    private String eventType; // 행사 종류
    private String place; // 행사 장소
    private String eventImage; // 행사 이미지
    private String eventInq; // 행사 대표문의처
    private String eventDesc; // 행사 설명
    private String eventStatus; // 진행 여부 (default: 'Y')
    private String startDate; // 행사 시작일자
    private String endDate; // 행사 종료일자
    private String regDate; // 등록일자
    private String lastUpdatedDate; // 수정일자
    private String deletedDate; // 삭제일자
    private String link; // 링크

    public EventJoinDto() {
    }

    public EventJoinDto(Long eventId, Long companyId, String eventName, String eventType, String place, String eventImage, String eventInq, String eventDesc, String eventStatus, String startDate, String endDate, String regDate, String deletedDate, String link) {
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
        this.deletedDate = deletedDate;
        this.link = link;
    }

    public EventJoinDto(String regDate, String eventName, String place, String eventDesc) {
        this.regDate = regDate;
        this.eventName = eventName;
        this.place = place;
        this.eventDesc = eventDesc;
    }

    //registerEvent()
    public EventJoinDto(Long companyId, String eventName, String eventType, String startDate, String endDate, String place, String eventInq, String eventImage, String eventDesc, String link) {
        this.companyId = companyId;
        this.eventName = eventName;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.eventInq = eventInq;
        this.eventImage = eventImage;
        this.eventDesc = eventDesc;
        this.link = link;
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

    public String getEventName() { return eventName; }

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

    public void setEventInq(String eventInq) { this.eventInq = eventInq; }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

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
