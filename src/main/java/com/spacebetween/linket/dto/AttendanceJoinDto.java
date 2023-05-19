package com.spacebetween.linket.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AttendanceJoinDto {
    private Long attId; // 출결 아이디
    private Long hireId;
    private Long eventId;
    private Long companyId;
    private String email;
    private LocalDate attDate; // 참여일
    private LocalDateTime attStartDatetime; // 출석일시
    private LocalDateTime attEndDatetime; // 퇴근일시
    private char attStartBnt; // 출석 버튼 활성화
    private char attEndBnt; // 퇴근 버튼 활성화
    private LocalDateTime regDate;

    //기본 생성자
    public AttendanceJoinDto(){}

    public AttendanceJoinDto(Long attId, Long hireId, Long eventId, Long companyId, String email, LocalDate attDate, LocalDateTime attStartDatetime, LocalDateTime attEndDatetime, char attStartBnt, char attEndBnt, LocalDateTime regDate) {
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

    public LocalDate getAttDate() {
        return attDate;
    }

    public void setAttDate(LocalDate attDate) {
        this.attDate = attDate;
    }

    public LocalDateTime getAttStartDatetime() {
        return attStartDatetime;
    }

    public void setAttStartDatetime(LocalDateTime attStartDatetime) {
        this.attStartDatetime = attStartDatetime;
    }

    public LocalDateTime getAttEndDatetime() {
        return attEndDatetime;
    }

    public void setAttEndDatetime(LocalDateTime attEndDatetime) {
        this.attEndDatetime = attEndDatetime;
    }

    public char getAttStartBnt() {
        return attStartBnt;
    }

    public void setAttStartBnt(char attStartBnt) {
        this.attStartBnt = attStartBnt;
    }

    public char getAttEndBnt() {
        return attEndBnt;
    }

    public void setAttEndBnt(char attEndBnt) {
        this.attEndBnt = attEndBnt;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
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
                ", attDate=" + attDate +
                ", attStartDatetime=" + attStartDatetime +
                ", attEndDatetime=" + attEndDatetime +
                ", attStartBnt=" + attStartBnt +
                ", attEndBnt=" + attEndBnt +
                ", regDate=" + regDate +
                '}';
    }
}
