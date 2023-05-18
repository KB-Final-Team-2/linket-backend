package com.spacebetween.linket.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AttendanceJoinDto {
    public AttendanceJoinDto(Long attId, LocalDate attDate, LocalDateTime attStartDatetime, LocalDateTime attEndDatetime, char attStartBnt, char attEndBnt, String attEmail, Long attEventId) {
        this.attId = attId;
        this.attDate = attDate;
        this.attStartDatetime = attStartDatetime;
        this.attEndDatetime = attEndDatetime;
        this.attStartBnt = attStartBnt;
        this.attEndBnt = attEndBnt;
        this.attEmail = attEmail;
        this.attEventId = attEventId;
    }

    public AttendanceJoinDto(){}

    private Long attId; // 출결 아이디
    private LocalDate attDate; // 참여일
    private LocalDateTime attStartDatetime; // 출석일시
    private LocalDateTime attEndDatetime; // 퇴근일시
    private char attStartBnt; // 출석 버튼 활성화
    private char attEndBnt; // 퇴근 버튼 활성화
    private String attEmail;
    private Long attEventId;

    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
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

    public String getAttEmail() {
        return attEmail;
    }

    public void setAttEmail(String attEmail) {
        this.attEmail = attEmail;
    }

    public Long getAttEventId() {
        return attEventId;
    }

    public void setAttEventId(Long attEventId) {
        this.attEventId = attEventId;
    }

    @Override
    public String toString() {
        return "AttendanceJoinDto{" +
                "attId=" + attId +
                ", attDate=" + attDate +
                ", attStartDatetime=" + attStartDatetime +
                ", attEndDatetime=" + attEndDatetime +
                ", attStartBnt=" + attStartBnt +
                ", attEndBnt=" + attEndBnt +
                ", attEmail='" + attEmail + '\'' +
                ", attEventId=" + attEventId +
                '}';
    }
}
