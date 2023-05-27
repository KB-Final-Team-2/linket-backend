package com.spacebetween.linket.domain;


public class Event {
    private Long eventId; // 행사 아이디 자동생성
    private Long companyId;
    private String eventName; // 행사명
    private String eventType; // 행사 종류
    private String place; // 행사 장소
    private String placeId; // 행사 고유 아이디
    private String eventImage; // 행사 이미지
    private String eventInq; // 행사 대표문의처
    private String eventDesc; // 행사 설명
    private String eventStatus; // 진행 여부 (default: 'Y')
    private String startDate; // 행사 시작일자
    private String endDate; // 행사 종료일자
    private String regDate; // 등록일자
    private String lastUpdatedDate; // 수정일자
    private String deletedDate; // 삭제일자
    private String link; // 링크
}
