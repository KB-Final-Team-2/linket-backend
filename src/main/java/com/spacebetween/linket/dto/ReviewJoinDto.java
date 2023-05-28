package com.spacebetween.linket.dto;


public class ReviewJoinDto {
    private Long reviewId; // 리뷰 아이디 자동생성
    private Long reviewTicketId;
    private Long reviewEventId;
    private Long reviewCompanyId;
    private Integer rateFacilChair;
    private Integer rateFacilRest;
    private Integer rateStaffIn;
    private Integer rateStaffTicket;
    private Integer rateEventContent;
    private Integer rateEventGo;
    private String reviewEtc;
    private String regDate;
    public ReviewJoinDto(){}

    public ReviewJoinDto(Long reviewId, Long reviewTicketId, Long reviewEventId, Long reviewCompanyId, Integer rateFacilChair, Integer rateFacilRest, Integer rateStaffIn, Integer rateStaffTicket, Integer rateEventContent, Integer rateEventGo, String reviewEtc, String regDate) {
        this.reviewId = reviewId;
        this.reviewTicketId = reviewTicketId;
        this.reviewEventId = reviewEventId;
        this.reviewCompanyId = reviewCompanyId;
        this.rateFacilChair = rateFacilChair;
        this.rateFacilRest = rateFacilRest;
        this.rateStaffIn = rateStaffIn;
        this.rateStaffTicket = rateStaffTicket;
        this.rateEventContent = rateEventContent;
        this.rateEventGo = rateEventGo;
        this.reviewEtc = reviewEtc;
        this.regDate = regDate;
    }

    public ReviewJoinDto(Long reviewTicketId, Long reviewEventId, Long reviewCompanyId, Integer rateFacilChair, Integer rateFacilRest, Integer rateStaffIn, Integer rateStaffTicket, Integer rateEventContent, Integer rateEventGo, String reviewEtc) {
        this.reviewTicketId = reviewTicketId;
        this.reviewEventId = reviewEventId;
        this.reviewCompanyId = reviewCompanyId;
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

    public Long getReviewTicketId() {
        return reviewTicketId;
    }

    public void setReviewTicketId(Long reviewTicketId) {
        this.reviewTicketId = reviewTicketId;
    }

    public Long getReviewEventId() {
        return reviewEventId;
    }

    public void setReviewEventId(Long reviewEventId) {
        this.reviewEventId = reviewEventId;
    }

    public Long getReviewCompanyId() {
        return reviewCompanyId;
    }

    public void setReviewCompanyId(Long reviewCompanyId) {
        this.reviewCompanyId = reviewCompanyId;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "ReviewJoinDto{" +
                "reviewId=" + reviewId +
                ", reviewTicketId=" + reviewTicketId +
                ", reviewEventId=" + reviewEventId +
                ", reviewCompanyId=" + reviewCompanyId +
                ", rateFacilChair=" + rateFacilChair +
                ", rateFacilRest=" + rateFacilRest +
                ", rateStaffIn=" + rateStaffIn +
                ", rateStaffTicket=" + rateStaffTicket +
                ", rateEventContent=" + rateEventContent +
                ", rateEventGo=" + rateEventGo +
                ", reviewEtc='" + reviewEtc + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
