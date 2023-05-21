package com.spacebetween.linket.service.review;

import com.spacebetween.linket.dto.ReviewJoinDto;

import java.util.List;

public interface ReviewService {
    int registerReview(ReviewJoinDto reviewJoinDto) throws Exception;
    List<ReviewJoinDto> getReviewStatus(Long eventId) throws Exception;
}
