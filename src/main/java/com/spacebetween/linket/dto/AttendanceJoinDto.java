package com.spacebetween.linket.dto;

public class AttendanceJoinDto {
    private Long attId; // 출결 아이디
    private Long attHireId;
    private Long attEventId;
    private Long attCompanyId;
    private String attEmail;
    private String attDate; // 참여일
    private String attStartDatetime; // 출석일시
    private String attEndDatetime; // 퇴근일시
    private String attStartBnt; // 출석 버튼 활성화
    private String attEndBnt; // 퇴근 버튼 활성화
    private String regDate;

    //기본 생성자
    public AttendanceJoinDto(){}

    public AttendanceJoinDto(Long attId, Long attHireId, Long attEventId, Long attCompanyId, String attEmail, String attDate, String attStartDatetime, String attEndDatetime, String attStartBnt, String attEndBnt, String regDate) {
        this.attId = attId;
        this.attHireId = attHireId;
        this.attEventId = attEventId;
        this.attCompanyId = attCompanyId;
        this.attEmail = attEmail;
        this.attDate = attDate;
        this.attStartDatetime = attStartDatetime;
        this.attEndDatetime = attEndDatetime;
        this.attStartBnt = attStartBnt;
        this.attEndBnt = attEndBnt;
        this.regDate = regDate;
    }

    public AttendanceJoinDto(String attEmail, Long attEventId){
        this.attEmail = attEmail;
        this.attEventId = attEventId;
    }


    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
    }

    public Long getAttHireId() {
        return attHireId;
    }

    public void setAttHireId(Long attHireId) {
        this.attHireId = attHireId;
    }

    public Long getAttEventId() {
        return attEventId;
    }

    public void setAttEventId(Long attEventId) {
        this.attEventId = attEventId;
    }

    public Long getAttCompanyId() {
        return attCompanyId;
    }

    public void setAttCompanyId(Long attCompanyId) {
        this.attCompanyId = attCompanyId;
    }

    public String getAttEmail() {
        return attEmail;
    }

    public void setAttEmail(String attEmail) {
        this.attEmail = attEmail;
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
                ", hireId=" + attHireId +
                ", eventId=" + attEventId +
                ", companyId=" + attCompanyId +
                ", email='" + attEmail + '\'' +
                ", attDate='" + attDate + '\'' +
                ", attStartDatetime='" + attStartDatetime + '\'' +
                ", attEndDatetime='" + attEndDatetime + '\'' +
                ", attStartBnt=" + attStartBnt +
                ", attEndBnt=" + attEndBnt +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}