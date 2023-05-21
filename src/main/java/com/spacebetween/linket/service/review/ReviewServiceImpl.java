package com.spacebetween.linket.service.review;

import com.spacebetween.linket.dao.review.ReviewDAO;
import com.spacebetween.linket.dto.ReviewJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDAO reviewDAO;

    @Override
    public int registerReview(ReviewJoinDto reviewJoinDto) throws Exception {
        return reviewDAO.registerReview(reviewJoinDto);
    }

    @Override
    public List<ReviewJoinDto> getReviewStatus(Long eventId) throws Exception {
        return reviewDAO.getReviewStatus(eventId);
    }
}
