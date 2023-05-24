package com.spacebetween.linket.dao.review;

import com.spacebetween.linket.dto.ReviewJoinDto;

import java.util.List;
import java.util.Map;

public interface ReviewDAO {
    int registerReview(ReviewJoinDto reviewJoinDto) throws Exception;
    List<Map<String, Object>> getReviewStatus(Long eventId) throws Exception;
    int checkReview(Long ticketId) throws Exception;
    List<Map<String, Object>> getAllReviews(String email) throws Exception;
}
