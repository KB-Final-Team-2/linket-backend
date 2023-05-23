package com.spacebetween.linket.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spacebetween.linket.dto.ReviewJoinDto;
import com.spacebetween.linket.service.review.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/reviews")
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
        @param reviewJoinDto 리뷰 정보
        @returnResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<?> registerReview(@RequestBody ReviewJoinDto reviewJoinDto) throws Exception{
        int result = reviewService.registerReview(reviewJoinDto);
        System.out.println(result);
        if(result==1) // 리뷰 등록 성공
            return new ResponseEntity<>(reviewJoinDto, header, HttpStatus.OK);

        else // 등록 실패
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Map<String, String>>> getReviewStatus(Long eventId) {
        try {
            List<Map<String, String>> reviewStatus = reviewService.getReviewStatus(eventId);
            return ResponseEntity.ok().headers(header).body(reviewStatus);
        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);
        }
    }
}
