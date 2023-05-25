package com.spacebetween.linket.dao.ticket;

import com.spacebetween.linket.dto.TicketJoinDto;


import java.util.List;
import java.util.Map;

public interface TicketDAO {
    String checkTicket(String serialNum) throws Exception;
    int registerTicket(TicketJoinDto ticketJoinDto) throws Exception;
    List<Map<String,Object>> getAllTickets(String email) throws Exception;
    Map<String,Object> getTicket(Long ticketId) throws Exception;
    int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception;
    List<Map<String,Object>> getTicketStatus(Long eventId) throws Exception;

}
