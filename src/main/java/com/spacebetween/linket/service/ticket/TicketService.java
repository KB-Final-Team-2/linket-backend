package com.spacebetween.linket.service.ticket;

import com.spacebetween.linket.dto.TicketJoinDto;


import java.util.List;
import java.util.Map;

public interface TicketService {
    int registerTicket(TicketJoinDto ticketJoinDto) throws Exception;
    List<Map<String,String>> getAllTickets(String email) throws Exception;
    Map<String,String> getTicket(Long ticketId) throws Exception;
    int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception;
}
