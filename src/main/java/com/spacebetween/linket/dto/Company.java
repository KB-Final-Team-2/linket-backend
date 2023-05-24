package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class Company {

    private Long companyId; // 기업 아이디 (난수로 생성하여 추가, Staff 가입시 입력해야하는 값)
    private String companyName; // 기업명
    private LocalDateTime regDate; // 등록일자
    private LocalDateTime deletedDate; // 삭제일자
}
