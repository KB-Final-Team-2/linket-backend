package com.spacebetween.linket.dto;

import java.time.LocalDateTime;

public class Review {

    private Long reviewId; // 리뷰 아이디 자동생성
    private String reviewContent; // 리뷰 내용
    private int rating; // 별점 (default: 5)
    private LocalDateTime regDate; // 리뷰등록일자
    private LocalDateTime deletedDate; // 리뷰삭제일자
}
