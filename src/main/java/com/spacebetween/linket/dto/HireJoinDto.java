package com.spacebetween.linket.dto;

public class HireJoinDto {
    private Long hireId;
    private Long hireEventId;
    private Long hireCompanyId;
    private String workName;
    private Integer workHour;
    private String workStartDay;
    private String workEndDay;
    private Integer pay;
    private String edu;
    private String regDate;

    public HireJoinDto(){}

    public HireJoinDto(Long hireId, Long hireEventId, Long hireCompanyId, String workName, Integer workHour, String workStartDay, String workEndDay, Integer pay, String edu, String regDate) {
        this.hireId = hireId;
        this.hireEventId = hireEventId;
        this.hireCompanyId = hireCompanyId;
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

    public Long getHireEventId() {
        return hireEventId;
    }

    public void setHireEventId(Long hireEventId) {
        this.hireEventId = hireEventId;
    }

    public Long getHireCompanyId() {
        return hireCompanyId;
    }

    public void setHireCompanyId(Long hireCompanyId) {
        this.hireCompanyId = hireCompanyId;
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
                ", eventId=" + hireEventId +
                ", companyId=" + hireCompanyId +
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
