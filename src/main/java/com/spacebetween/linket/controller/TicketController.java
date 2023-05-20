package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.TicketJoinDto;
import com.spacebetween.linket.service.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private static HttpHeaders header;
    static{
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private TicketService ticketService;

    @PostMapping("/user")
    public ResponseEntity<String> registerTicket(@PathVariable Long ticketId,HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");
        TicketJoinDto ticketJoinDto = new TicketJoinDto();
        ticketJoinDto.setEmail(email);
        ticketJoinDto.setTicketId(ticketId);

        int rowCnt = ticketService.registerTicket(ticketJoinDto);

        if(rowCnt==1){
            String success = "success";
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else {
            String fail = "fail";
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping
    public ResponseEntity<List<TicketJoinDto>> getAllTickets(HttpSession session) throws Exception {
        String email = (String) session.getAttribute("email");

        List<TicketJoinDto> list = ticketService.getAllTickets(email);

        for (TicketJoinDto ticketJoinDto:list) {
            if (!email.equals(ticketJoinDto.getEmail()))
                return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(list, header, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<TicketJoinDto> getTicket(@PathVariable Long ticketId) throws Exception{

        TicketJoinDto ticketJoinDto = ticketService.getTicket(ticketId);

        if(ticketId.equals(ticketJoinDto.getTicketId()))
            return new ResponseEntity<>(ticketJoinDto, header, HttpStatus.OK);
        else
            return new ResponseEntity<>(null,header, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/user/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long ticketId) throws Exception{

        TicketJoinDto ticketJoinDto = new TicketJoinDto();
        ticketJoinDto.setTicketId(ticketId);
        ticketJoinDto.setTicketStatus('N');

        int rowCnt = ticketService.deleteTicket(ticketJoinDto);

        if(rowCnt==1){
            String success = "success";
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else {
            String fail = "fail";
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }
    }

}
