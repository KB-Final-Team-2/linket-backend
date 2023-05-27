package com.spacebetween.linket.dto;

public class HireJoinDto {
    private Long hireId;
    private Long eventId;
    private Long companyId;
    private String workName;
    private Integer workHour;
    private String workStartDay;
    private String workEndDay;
    private Integer pay;
    private String edu;
    private String regDate;

    public HireJoinDto(){}

    public HireJoinDto(Long hireId, Long eventId, Long companyId, String workName, Integer workHour, String workStartDay, String workEndDay, Integer pay, String edu, String regDate) {
        this.hireId = hireId;
        this.eventId = eventId;
        this.companyId = companyId;
        this.workName = workName;
        this.workHour = workHour;
        this.workStartDay = workStartDay;
        this.workEndDay = workEndDay;
        this.pay = pay;
        this.edu = edu;
        this.regDate = regDate;
    }

    //registerHire()
    public HireJoinDto(String workName, Integer workHour, String workStartDay, String workEndDay, Integer pay, String edu, String regDate) {
        this.workName = workName;
        this.workHour = workHour;
        this.workStartDay = workStartDay;
        this.workEndDay = workEndDay;
        this.pay = pay;
        this.edu = edu;
        this.regDate = regDate;
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
    public String getWorkName(){ return workName; }
    public void setWorkName(String workName){this.workName=workName;}

    public Integer getWorkHour() {
        return workHour;
    }

    public void setWorkHour(Integer workHour) {
        this.workHour = workHour;
    }

    public String getWorkStartDay() {
        return workStartDay;
    }

    public void setWorkStartDay(String workStartDay) {
        this.workStartDay = workStartDay;
    }

    public String getWorkEndDay() {
        return workEndDay;
    }

    public void setWorkEndDay(String workEndDay) {
        this.workEndDay = workEndDay;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "HireJoinDto{" +
                "hireId=" + hireId +
                ", eventId=" + eventId +
                ", companyId=" + companyId +
                ", workName='" + workName + '\'' +
                ", workHour=" + workHour +
                ", workStartDay=" + workStartDay +
                ", workEndDay=" + workEndDay +
                ", pay=" + pay +
                ", edu='" + edu + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
