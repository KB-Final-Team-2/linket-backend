package com.spacebetween.linket.dao.review;

import com.spacebetween.linket.dto.ReviewJoinDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

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
                3,3,2,"", LocalDateTime.now());

        int rowCnt = reviewDAO.registerReview(reviewJoinDto);
        assertTrue(rowCnt==1);
    }

    @Test
    public void getReviewStatus() throws Exception{
        List<ReviewJoinDto> reviewList = reviewDAO.getReviewStatus(1L);
        for (ReviewJoinDto reviewJoinDto : reviewList) {
            System.out.println(reviewJoinDto);
        }
    }


}
