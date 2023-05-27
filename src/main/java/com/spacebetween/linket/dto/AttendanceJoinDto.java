package com.spacebetween.linket.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AttendanceJoinDto {
    private Long attId; // 출결 아이디
    private Long hireId;
    private Long eventId;
    private Long companyId;
    private String email;
    private String attDate; // 참여일
    private String attStartDatetime; // 출석일시
    private String attEndDatetime; // 퇴근일시
    private String attStartBnt; // 출석 버튼 활성화
    private String attEndBnt; // 퇴근 버튼 활성화
    private String regDate;

    //기본 생성자
    public AttendanceJoinDto(){}

    public AttendanceJoinDto(Long attId, Long hireId, Long eventId, Long companyId, String email, String attDate, String attStartDatetime, String attEndDatetime, String attStartBnt, String attEndBnt, String regDate) {
        this.attId = attId;
        this.hireId = hireId;
        this.eventId = eventId;
        this.companyId = companyId;
        this.email = email;
        this.attDate = attDate;
        this.attStartDatetime = attStartDatetime;
        this.attEndDatetime = attEndDatetime;
        this.attStartBnt = attStartBnt;
        this.attEndBnt = attEndBnt;
        this.regDate = regDate;
    }

    public AttendanceJoinDto(String email, Long eventId){
        this.email = email;
        this.eventId = eventId;
    }


    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
    }

    public Long getHireId() {
        return hireId;
    }

    public void setHireId(Long hireId) {
        this.hireId = hireId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAttDate() {
        return attDate;
    }

    public void setAttDate(String attDate) {
        this.attDate = attDate;
    }

    public String getAttStartDatetime() {
        return attStartDatetime;
    }

    public void setAttStartDatetime(String attStartDatetime) {
        this.attStartDatetime = attStartDatetime;
    }

    public String getAttEndDatetime() {
        return attEndDatetime;
    }

    public void setAttEndDatetime(String attEndDatetime) {
        this.attEndDatetime = attEndDatetime;
    }

    public String getAttStartBnt() {
        return attStartBnt;
    }

    public void setAttStartBnt(String attStartBnt) {
        this.attStartBnt = attStartBnt;
    }

    public String getAttEndBnt() {
        return attEndBnt;
    }

    public void setAttEndBnt(String attEndBnt) {
        this.attEndBnt = attEndBnt;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "AttendanceJoinDto{" +
                "attId=" + attId +
                ", hireId=" + hireId +
                ", eventId=" + eventId +
                ", companyId=" + companyId +
                ", email='" + email + '\'' +
                ", attDate='" + attDate + '\'' +
                ", attStartDatetime='" + attStartDatetime + '\'' +
                ", attEndDatetime='" + attEndDatetime + '\'' +
                ", attStartBnt=" + attStartBnt +
                ", attEndBnt=" + attEndBnt +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}