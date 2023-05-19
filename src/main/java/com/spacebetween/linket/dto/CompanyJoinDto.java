package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class CompanyJoinDto {
    private Long companyId; // 기업 아이디 (난수로 생성하여 추가, Staff 가입시 입력해야하는 값)
    private String companyName; // 기업명
    private LocalDateTime regDate; // 등록일자
    private LocalDateTime deletedDate; // 삭제일자

    public CompanyJoinDto(){}

    public CompanyJoinDto(Long companyId, String companyName, LocalDateTime regDate, LocalDateTime deletedDate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.regDate = regDate;
        this.deletedDate = deletedDate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public String toString() {
        return "CompanyJoinDto{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", regDate=" + regDate +
                ", deletedDate=" + deletedDate +
                '}';
    }
}
