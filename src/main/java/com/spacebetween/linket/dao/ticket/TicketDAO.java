package com.spacebetween.linket.dao.ticket;

import com.spacebetween.linket.dto.TicketJoinDto;


import java.util.List;
import java.util.Map;

public interface TicketDAO {
    int registerTicket(TicketJoinDto ticketJoinDto) throws Exception;
    List<Map<String,String>> getAllTickets(String email) throws Exception;
    Map<String,String> getTicket(Long ticketId) throws Exception;
    int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception;
    List<Map<String,String>> getTicketStatus(Long eventId) throws Exception;

}
