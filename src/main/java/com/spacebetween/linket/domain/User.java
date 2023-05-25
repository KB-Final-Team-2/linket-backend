package com.spacebetween.linket.domain;


public class User {

    private String email; // 사용자 이메일
    private String password; // 사용자 비밀번호
    private String userName; // 사용자 이름
    private String birthdate; // 생년월일
    private boolean agreement; // 개인정보동의 표시 (default: false)
    private String phone; // 전화번호
    private char gender; // 성별
    private String role; // 사용자 권한 (admin, member, staff, part)
    private String account; // part-time 계좌
    private String regDate; // 회원가입일자
    private String withdrawDate; // 회원탈퇴일자
    private char enabled; // 회원 탈퇴여부
    private String lastUpdatedDate; // 회원정보 수정일자

    private int companyId;
}
