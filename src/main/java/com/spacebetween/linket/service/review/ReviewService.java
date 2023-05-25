package com.spacebetween.linket.service.review;

import com.spacebetween.linket.dto.ReviewJoinDto;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    int registerReview(ReviewJoinDto reviewJoinDto) throws Exception;
    List<Map<String, Object>> getReviewStatus(Long eventId) throws Exception;
    int checkReview(Long ticketId) throws Exception;
    List<Map<String, Object>> getAllReviews(String email) throws Exception;
}
