package com.spacebetween.linket.domain;


public class Attendance {
    private Long attId; // 출결 아이디
    private Long hireId;
    private Long eventId;
    private Long companyId;
    private String email;
    private int attDate; // 참여일
    private String attStartDatetime; // 출석일시
    private String attEndDatetime; // 퇴근일시
    private char attStartBnt; // 출석 버튼 활성화
    private char attEndBnt; // 퇴근 버튼 활성화
    private String regDate;

}
