package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class TicketJoinDto {
    private Long ticketId; // 티켓 아이디 자동생성
    private Long eventId;
    private Long companyId;
    private String email;
    private String serialNum; // 일련번호
    private char ticketReg; // 티켓 등록여부 (일련번호 사용성여부 파악, default: 'N')
    private char ticketStatus; // 티켓 사용가능여부 (default: 'Y')
    private LocalDateTime regDate; // 티켓등록일자
    private LocalDateTime lastUpdatedDate; // 수정일자

    public TicketJoinDto(){}

    public TicketJoinDto(Long ticketId, Long eventId, Long companyId, String email, String serialNum, char ticketReg, char ticketStatus, LocalDateTime regDate, LocalDateTime lastUpdatedDate) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.companyId = companyId;
        this.email = email;
        this.serialNum = serialNum;
        this.ticketReg = ticketReg;
        this.ticketStatus = ticketStatus;
        this.regDate = regDate;
        this.lastUpdatedDate = lastUpdatedDate;
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

    public char getTicketReg() {
        return ticketReg;
    }

    public void setTicketReg(char ticketReg) {
        this.ticketReg = ticketReg;
    }

    public char getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(char ticketStatus) {
        this.ticketStatus = ticketStatus;
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
                '}';
    }
}
