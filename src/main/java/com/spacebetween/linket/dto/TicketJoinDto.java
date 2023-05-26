package com.spacebetween.linket.dto;


public class TicketJoinDto {
    private Long ticketId; // 티켓 아이디 자동생성
    private Long eventId;
    private Long companyId;
    private String email;
    private String serialNum; // 일련번호
    private String ticketReg; // 티켓 등록여부 (일련번호 사용성여부 파악, default: 'N')
    private String ticketStatus; // 티켓 사용가능여부 (default: 'Y')
    private String regDate; // 티켓등록일자
    private String lastUpdatedDate; // 수정일자
    private String seat; //  좌석

    public TicketJoinDto(){}

    public TicketJoinDto(Long ticketId, Long eventId, Long companyId, String email, String serialNum, String ticketReg, String ticketStatus, String regDate, String lastUpdatedDate, String seat) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.companyId = companyId;
        this.email = email;
        this.serialNum = serialNum;
        this.ticketReg = ticketReg;
        this.ticketStatus = ticketStatus;
        this.regDate = regDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.seat = seat;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getTicketReg() {
        return ticketReg;
    }

    public void setTicketReg(String ticketReg) {
        this.ticketReg = ticketReg;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
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

    public String getSeat() { return seat; }

    public void setSeat(String seat) { this.seat = seat;}

    @Override
    public String toString() {
        return "TicketJoinDto{" +
                "ticketId=" + ticketId +
                ", eventId=" + eventId +
                ", companyId=" + companyId +
                ", email='" + email + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", ticketReg=" + ticketReg +
                ", ticketStatus=" + ticketStatus +
                ", regDate=" + regDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", seat='" + seat + '\'' +
                '}';
    }
}
