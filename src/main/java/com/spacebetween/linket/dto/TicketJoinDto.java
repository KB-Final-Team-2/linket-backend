package com.spacebetween.linket.dto;


public class TicketJoinDto {
    private Long ticketId; // 티켓 아이디 자동생성
    private Long ticketEventId;
    private Long ticketCompanyId;
    private String ticketEmail;
    private String serialNum; // 일련번호
    private String ticketReg; // 티켓 등록여부 (일련번호 사용성여부 파악, default: 'N')
    private String ticketStatus; // 티켓 사용가능여부 (default: 'Y')
    private String regDate; // 티켓등록일자
    private String lastUpdatedDate; // 수정일자
    private String seat; //  좌석

    public TicketJoinDto(){}

    public TicketJoinDto(Long ticketId, Long ticketEventId, Long ticketCompanyId, String ticketEmail, String serialNum, String ticketReg, String ticketStatus, String regDate, String lastUpdatedDate, String seat) {
        this.ticketId = ticketId;
        this.ticketEventId = ticketEventId;
        this.ticketCompanyId = ticketCompanyId;
        this.ticketEmail = ticketEmail;
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

    public Long getTicketEventId() {
        return ticketEventId;
    }

    public void setTicketEventId(Long ticketEventId) {
        this.ticketEventId = ticketEventId;
    }

    public Long getTicketCompanyId() {
        return ticketCompanyId;
    }

    public void setTicketCompanyId(Long ticketCompanyId) {
        this.ticketCompanyId = ticketCompanyId;
    }

    public String getTicketEmail() {
        return ticketEmail;
    }

    public void setTicketEmail(String ticketEmail) {
        this.ticketEmail = ticketEmail;
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
                ", ticketEventId=" + ticketEventId +
                ", ticketCompanyId=" + ticketCompanyId +
                ", ticketEmail='" + ticketEmail + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", ticketReg='" + ticketReg + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", regDate='" + regDate + '\'' +
                ", lastUpdatedDate='" + lastUpdatedDate + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
