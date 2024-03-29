package com.spacebetween.linket.dao.review;

import com.spacebetween.linket.dto.ReviewJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
    public static final String NS = "com.spacebetween.linket.mapper.ReviewMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int registerReview(ReviewJoinDto reviewJoinDto) throws Exception {
        return sqlSession.insert(NS+"registerReview", reviewJoinDto);
    }

    @Override
    public List<Map<String, Object>> getReviewStatus(Long eventId) throws Exception {
        return sqlSession.selectList(NS+"getReviewStatus",eventId);
    }

    @Override
    public int checkReview(Long ticketId) throws Exception {
        return sqlSession.selectOne(NS+"checkReview",ticketId);
    }

    @Override
    public List<Map<String, Object>> getAllReviews(String email) throws Exception {
        return sqlSession.selectList(NS+"getAllReviews",email);
    }
}
