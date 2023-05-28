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
        리뷰 등록 여부 확인
     */
    @PostMapping("/member/{ticketId}/review/check")
    public ResponseEntity<String> checkReview(@PathVariable Long ticketId) throws Exception{
        int cnt = reviewService.checkReview(ticketId);

        if(cnt==0) {// 리뷰 등록 성공
            String result = "able";
            return new ResponseEntity<>(result, header, HttpStatus.OK);
        }else {// 등록 실패
            String result = "existed";
            return new ResponseEntity<>(result, header, HttpStatus.BAD_REQUEST);
        }
    }
    /*
        리뷰 등록 API
    */
    @PostMapping("/member/review")
    public ResponseEntity<ReviewJoinDto> registerReview(@RequestBody ReviewJoinDto reviewJoinDto) throws Exception{
        int rowCnt = reviewService.registerReview(reviewJoinDto);
        if(rowCnt==1) // 리뷰 등록 성공
            return new ResponseEntity<>(reviewJoinDto, header, HttpStatus.OK);
        else // 등록 실패
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
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


//member가 자신의 리뷰를 모두 조회합니다.
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
