package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class Event {

    private Long eventId; // 행사 아이디 자동생성
    private String eventName; // 행사명
    private String eventType; // 행사 종류
    private String place; // 행사 장소
    private String eventInq; // 행사 대표문의처
    private String eventDesc; // 행사 설명
    private char eventStatus; // 진행 여부 (default: 'Y')
    private String startDate; // 행사 시작일자
    private String endDate; // 행사 종료일자
    private LocalDateTime regDate; // 등록일자
    private LocalDateTime lastUpdatedDate; // 수정일자
    private LocalDateTime deletedDate; // 삭제일자
}
