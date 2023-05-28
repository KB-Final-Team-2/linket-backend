package com.spacebetween.linket.domain;


public class Attendance {
    private Long attId; // 출결 아이디
    private Long attHireId;
    private Long attEventId;
    private Long attCompanyId;
    private String attEmail;
    private String attStartDatetime; // 출석일시
    private String attEndDatetime; // 퇴근일시
    private String attStartBnt; // 출석 버튼 활성화
    private String attEndBnt; // 퇴근 버튼 활성화
    private String regDate;

}
