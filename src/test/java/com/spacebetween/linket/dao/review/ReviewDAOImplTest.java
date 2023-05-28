package com.spacebetween.linket.dao.review;

import com.spacebetween.linket.dto.ReviewJoinDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ReviewDAOImplTest {
    @Autowired
    ReviewDAO reviewDAO;

    @Test
    public void testRegisterReview() throws Exception{
        ReviewJoinDto reviewJoinDto = new ReviewJoinDto(
                2L,1L,12345L,3,3,3,
                3,3,2,"");

        int rowCnt = reviewDAO.registerReview(reviewJoinDto);
        assertTrue(rowCnt==1);
    }

    @Test
    public void getReviewStatus() throws Exception{
        List<Map<String, Object>> reviewList = reviewDAO.getReviewStatus(1L);
        for (Map<String, Object> reviewJoinDto : reviewList) {
            System.out.println(reviewJoinDto);
        }
    }

    @Test
    public void checkReview() throws Exception{
        int result = reviewDAO.checkReview(2L);
        System.out.println(result);
    }

    @Test
    public void getAllReviews() throws Exception{
        List<Map<String, Object>> reviewList = reviewDAO.getAllReviews("member@me.com");
        for (Map<String, Object> review : reviewList) {
            System.out.println(review);
        }
    }


}
