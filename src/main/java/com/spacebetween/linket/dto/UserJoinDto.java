package com.spacebetween.linket.dto;

public class UserJoinDto {
    private String email; // 사용자 이메일
    private long userCompanyId;
    private String password; // 사용자 비밀번호
    private String userName; // 사용자 이름
    private String birthdate; // 생년월일
    private int agreement; // 개인정보동의 표시 (default: false)
    private String phone; // 전화번호
    private String gender; // 성별
    private String role; // 사용자 권한 (admin, member, staff, part)
    private String account;
    private String regDate; // 회원가입일자
    private String withdrawDate; // 회원탈퇴일자
    private String enabled; // 회원 탈퇴여부
    private String lastUpdatedDate; // 회원정보 수정일자


    public UserJoinDto(String email, String password, String userName, String birthdate, int agreement, String phone, String gender, String role, String account, String regDate, String withdrawDate, String enabled, String lastUpdatedDate, long userCompanyId) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.birthdate = birthdate;
        this.agreement = agreement;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
        this.account = account;
        this.regDate = regDate;
        this.withdrawDate = withdrawDate;
        this.enabled = enabled;
        this.lastUpdatedDate = lastUpdatedDate;
        this.userCompanyId = userCompanyId;
    }

    public UserJoinDto(String email, String password, String userName, String birthdate, int agreement, String phone, String gender, String role, String account, String withdrawDate, String enabled, String lastUpdatedDate, long userCompanyId) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.birthdate = birthdate;
        this.agreement = agreement;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
        this.account = account;
        this.withdrawDate = withdrawDate;
        this.enabled = enabled;
        this.lastUpdatedDate = lastUpdatedDate;
        this.userCompanyId = userCompanyId;
    }

    public UserJoinDto(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getAgreement() {
        return agreement;
    }

    public void setAgreement(int agreement) {
        this.agreement = agreement;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(String withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public long getUserCompanyId() {
        return userCompanyId;
    }

    public void setUserCompanyId(long userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    @Override
    public String toString() {
        return "UserJoinDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", agreement=" + agreement +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", account='" + account + '\'' +
                ", regDate='" + regDate + '\'' +
                ", withdrawDate='" + withdrawDate + '\'' +
                ", enabled='" + enabled + '\'' +
                ", lastUpdatedDate='" + lastUpdatedDate + '\'' +
                ", companyId=" + userCompanyId +
                '}';
    }
}
