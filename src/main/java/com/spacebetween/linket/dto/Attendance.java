package com.spacebetween.linket.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Attendance {

    private Long attId; // 출결 아이디
    private LocalDate attDate; // 참여일
    private LocalDateTime attStartDatetime; // 출석일시
    private LocalDateTime attEndDatetime; // 퇴근일시
    private char attStartBnt; // 출석 버튼 활성화
    private char attEndBnt; // 퇴근 버튼 활성화
}
