package com.spacebetween.linket.service.ticket;

import com.spacebetween.linket.dao.ticket.TicketDAO;
import com.spacebetween.linket.dto.TicketJoinDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketDAO ticketDAO;

    @Override
    public int registerTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return ticketDAO.registerTicket(ticketJoinDto);
    }

    @Override
    public List<Map<String,String>> getAllTickets(String email) throws Exception {
        return ticketDAO.getAllTickets(email);
    }

    @Override
    public Map<String,String> getTicket(Long ticketId) throws Exception {
        return ticketDAO.getTicket(ticketId);
    }

    @Override
    public int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return ticketDAO.deleteTicket(ticketJoinDto);
    }

    @Override
    public List<Map<String, String>> getTicketStatus(Long eventId) throws Exception {
        return ticketDAO.getTicketStatus(eventId);
    }


}