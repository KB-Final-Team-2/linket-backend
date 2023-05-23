package com.spacebetween.linket.service.review;

import com.spacebetween.linket.dto.ReviewJoinDto;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    int registerReview(ReviewJoinDto reviewJoinDto) throws Exception;
    List<Map<String,String>> getReviewStatus(Long eventId) throws Exception;
}
