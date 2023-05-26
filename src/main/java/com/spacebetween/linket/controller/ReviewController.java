package com.spacebetween.linket.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spacebetween.linket.dto.ReviewJoinDto;
import com.spacebetween.linket.service.review.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private static HttpHeaders header;
    static{
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private ReviewService reviewService;

    /*
        리뷰 등록 API
     */

    @PostMapping("/member/{ticketId}/review")
    public ResponseEntity<ReviewJoinDto> registerReview(@RequestBody ReviewJoinDto reviewJoinDto,@PathVariable Long ticketId) throws Exception{
        int cnt = reviewService.checkReview(ticketId);

        if(cnt==0) {// 해당하는 티켓의 리뷰 존재하지 않음.
            int rowCnt = reviewService.registerReview(reviewJoinDto);
            System.out.println(rowCnt);
            if(rowCnt==1) // 리뷰 등록 성공
                return new ResponseEntity<>(reviewJoinDto, header, HttpStatus.OK);
            else // 등록 실패
                return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
        }else {// 리뷰 존재
            ReviewJoinDto result = new ReviewJoinDto();
            return new ResponseEntity<>(result, header, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/staff/{eventId}/status")
    public ResponseEntity<List<Map<String, Object>>> getReviewStatus(@PathVariable Long eventId) throws Exception {
        try {
            List<Map<String, Object>> reviewStatus = reviewService.getReviewStatus(eventId);
            return ResponseEntity.ok().headers(header).body(reviewStatus);
        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);
        }
    }



    @GetMapping("/member/reviews")
    public ResponseEntity<List<Map<String, Object>>> getAllReviews(HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");
//        String email = "red1@member.com";
        List<Map<String, Object>> reviewList = reviewService.getAllReviews(email);

        try {
            return ResponseEntity.ok().headers(header).body(reviewList);
        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);
        }
    }


}
