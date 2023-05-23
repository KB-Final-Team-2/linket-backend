package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class ReviewJoinDto {
    private Long reviewId; // 리뷰 아이디 자동생성
    private Long ticketId;
    private Long eventId;
    private Long companyId;
    private Integer rateFacilChair;
    private Integer rateFacilRest;
    private Integer rateStaffIn;
    private Integer rateStaffTicket;
    private Integer rateEventContent;
    private Integer rateEventGo;
    private String reviewEtc;
    private LocalDateTime regDate;
    public ReviewJoinDto(){}

    public ReviewJoinDto(Long reviewId, Long ticketId, Long eventId, Long companyId, Integer rateFacilChair, Integer rateFacilRest, Integer rateStaffIn, Integer rateStaffTicket, Integer rateEventContent, Integer rateEventGo, String reviewEtc, LocalDateTime regDate) {
        this.reviewId = reviewId;
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.companyId = companyId;
        this.rateFacilChair = rateFacilChair;
        this.rateFacilRest = rateFacilRest;
        this.rateStaffIn = rateStaffIn;
        this.rateStaffTicket = rateStaffTicket;
        this.rateEventContent = rateEventContent;
        this.rateEventGo = rateEventGo;
        this.reviewEtc = reviewEtc;
        this.regDate = regDate;
    }

    public ReviewJoinDto(Long ticketId, Long eventId, Long companyId, Integer rateFacilChair, Integer rateFacilRest, Integer rateStaffIn, Integer rateStaffTicket, Integer rateEventContent, Integer rateEventGo, String reviewEtc) {
        this.ticketId = ticketId;
        this.eventId = eventId;
        this.companyId = companyId;
        this.rateFacilChair = rateFacilChair;
        this.rateFacilRest = rateFacilRest;
        this.rateStaffIn = rateStaffIn;
        this.rateStaffTicket = rateStaffTicket;
        this.rateEventContent = rateEventContent;
        this.rateEventGo = rateEventGo;
        this.reviewEtc = reviewEtc;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
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

    public Integer getRateFacilChair() {
        return rateFacilChair;
    }

    public void setRateFacilChair(Integer rateFacilChair) {
        this.rateFacilChair = rateFacilChair;
    }

    public Integer getRateFacilRest() {
        return rateFacilRest;
    }

    public void setRateFacilRest(Integer rateFacilRest) {
        this.rateFacilRest = rateFacilRest;
    }

    public Integer getRateStaffIn() {
        return rateStaffIn;
    }

    public void setRateStaffIn(Integer rateStaffIn) {
        this.rateStaffIn = rateStaffIn;
    }

    public Integer getRateStaffTicket() {
        return rateStaffTicket;
    }

    public void setRateStaffTicket(Integer rateStaffTicket) {
        this.rateStaffTicket = rateStaffTicket;
    }

    public Integer getRateEventContent() {
        return rateEventContent;
    }

    public void setRateEventContent(Integer rateEventContent) {
        this.rateEventContent = rateEventContent;
    }

    public Integer getRateEventGo() {
        return rateEventGo;
    }

    public void setRateEventGo(Integer rateEventGo) {
        this.rateEventGo = rateEventGo;
    }

    public String getReviewEtc() {
        return reviewEtc;
    }

    public void setReviewEtc(String reviewEtc) {
        this.reviewEtc = reviewEtc;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "ReviewJoinDto{" +
                "reviewId=" + reviewId +
                ", ticketId=" + ticketId +
                ", eventId=" + eventId +
                ", companyId=" + companyId +
                ", rateFacilChair=" + rateFacilChair +
                ", rateFacilRest=" + rateFacilRest +
                ", rateStaffIn=" + rateStaffIn +
                ", rateStaffTicket=" + rateStaffTicket +
                ", rateEventContent=" + rateEventContent +
                ", rateEventGo=" + rateEventGo +
                ", reviewEtc='" + reviewEtc + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
