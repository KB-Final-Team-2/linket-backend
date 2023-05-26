package com.spacebetween.linket.domain;


public class Ticket {

    private Long ticketId; // 티켓 아이디 자동생성
    private Long eventId;
    private Long companyId;
    private String email;
    private String serialNum; // 일련번호
    private String ticketReg; // 티켓 등록여부 (일련번호 사용성여부 파악, default: 'N')
    private String ticketStatus; // 티켓 사용가능여부 (default: 'Y')
    private String regDate; // 티켓등록일자
    private String lastUpdatedDate; // 수정일자
    private String seat; // 좌석
}
