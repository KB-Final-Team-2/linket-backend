package com.spacebetween.linket.dao.ticket;

import com.spacebetween.linket.dto.TicketJoinDto;


import java.util.List;

public interface TicketDAO {
    int registerTicket(TicketJoinDto ticketJoinDto) throws Exception;
    List<TicketJoinDto> getAllTickets(String email) throws Exception;
    TicketJoinDto getTicket(Long ticketId) throws Exception;
    int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception;
}
