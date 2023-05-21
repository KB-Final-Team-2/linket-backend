package com.spacebetween.linket.dao.review;

import com.spacebetween.linket.dto.ReviewJoinDto;

import java.util.List;

public interface ReviewDAO {
    int registerReview(ReviewJoinDto reviewJoinDto) throws Exception;
    List<ReviewJoinDto> getReviewStatus(Long eventId) throws Exception;

}
