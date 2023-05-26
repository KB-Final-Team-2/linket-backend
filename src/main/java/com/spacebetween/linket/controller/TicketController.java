package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.TicketJoinDto;
import com.spacebetween.linket.exception.ErrorCode;
import com.spacebetween.linket.service.ticket.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.*;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    private static HttpHeaders header;

    static {
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private TicketService ticketService;


    /*
        티켓 등록 API + 중복여부 확인
    */
    @PatchMapping("/user/{serialNum}")
    public ResponseEntity<String> registerTicket(@PathVariable String serialNum, HttpSession session) throws Exception {
        String result = ticketService.checkTicket(serialNum);
        if (result.equals("able")) {
            String email = (String) session.getAttribute("email");
            TicketJoinDto ticketJoinDto = new TicketJoinDto();
//        String email = "red1@member.com";
            ticketJoinDto.setEmail(email);
            ticketJoinDto.setSerialNum(serialNum);
            int rowCnt = ticketService.registerTicket(ticketJoinDto);
            if (rowCnt == 1) {
                String success = new String("success");
                return new ResponseEntity<>(success, header, HttpStatus.OK);
            } else { // 티켓 등록 실패
                String fail = new String("fail");
                return new ResponseEntity<>(ErrorCode.TICKET_NOT_FOUND.getMessage(), header, HttpStatus.BAD_REQUEST);
            }
        } else {// 티켓 중복
            return new ResponseEntity<>(ErrorCode.ALREADY_SAVED_TICKET.getMessage(), header, HttpStatus.BAD_REQUEST);
        }
    }

    /*
        티켓 전체 조회 API
        멤버가 등록한 것
    */
    @GetMapping("/user/list")
    public ResponseEntity<List<Map<String, Object>>> getAllTickets(HttpSession session) throws Exception {
        String email = (String)session.getAttribute("email");
//        String email = "red1@member.com";
        try {
            List<Map<String, Object>> tickets = ticketService.getAllTickets(email);
            return ResponseEntity.ok().headers(header).body(tickets);
        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);
        }
    }

    /*
        티켓 단일 조회 API
        멤버가 등록한 것
    */
    @GetMapping("/user/{ticketId}")
    public ResponseEntity<Map<String, Object>> getTicket(@PathVariable Long ticketId) throws Exception {
        try {
            Map<String, Object> ticket = ticketService.getTicket(ticketId);
            if (ticket != null) {
                return ResponseEntity.ok().headers(header).body(ticket);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);
        }
    }


    /*
        티켓 삭제 API
        멤버가 등록한 것
    */
    @DeleteMapping("/user/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Long ticketId) {
        try {
            TicketJoinDto ticketJoinDto = new TicketJoinDto();
            ticketJoinDto.setTicketId(ticketId);
            int rowCnt = ticketService.deleteTicket(ticketJoinDto);
            if (rowCnt == 1) {
                return ResponseEntity.ok().headers(header).body("티켓이 삭제되었습니다.");
            } else {
                return new ResponseEntity<>(ErrorCode.TICKET_NOT_FOUND.getMessage(), header, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(ErrorCode.TICKET_NOT_FOUND.getMessage(), header, HttpStatus.BAD_REQUEST);
        }
    }


    /*
        티켓 삭제 API
        멤버가 등록한 것
    */
    @GetMapping("/staff/{eventId}/status/mem")
    public ResponseEntity<List<Map<String, Object>>> getTicketStatus(@PathVariable("eventId") Long eventId) {
        try {
            List<Map<String, Object>> ticketStatusList = ticketService.getTicketStatus(eventId);
            return ResponseEntity.ok().headers(header).body(ticketStatusList);
        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);
        }
    }

}