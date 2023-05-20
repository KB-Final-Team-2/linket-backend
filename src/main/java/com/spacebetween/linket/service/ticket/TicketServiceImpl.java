package com.spacebetween.linket.service.ticket;

import com.spacebetween.linket.dao.ticket.TicketDAO;
import com.spacebetween.linket.dto.TicketJoinDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketDAO ticketDAO;

    @Override
    public int registerTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return ticketDAO.registerTicket(ticketJoinDto);
    }

    @Override
    public List<TicketJoinDto> getAllTickets(String email) throws Exception {
        return ticketDAO.getAllTickets(email);
    }

    @Override
    public TicketJoinDto getTicket(Long ticketId) throws Exception {
        return ticketDAO.getTicket(ticketId);
    }

    @Override
    public int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return ticketDAO.deleteTicket(ticketJoinDto);
    }


}