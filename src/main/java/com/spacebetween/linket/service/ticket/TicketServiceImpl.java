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
    public String checkTicket(String serialNum) throws Exception {
        return ticketDAO.checkTicket(serialNum);
    }

    @Override
    public int registerTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return ticketDAO.registerTicket(ticketJoinDto);
    }

    @Override
    public List<Map<String,Object>> getAllTickets(String ticketEmail) throws Exception {
        return ticketDAO.getAllTickets(ticketEmail);
    }

    @Override
    public Map<String,Object> getTicket(Long ticketId) throws Exception {
        return ticketDAO.getTicket(ticketId);
    }

    @Override
    public int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return ticketDAO.deleteTicket(ticketJoinDto);
    }

    @Override
    public List<Map<String,Object>> getTicketStatus(Long ticketEventId) throws Exception {
        return ticketDAO.getTicketStatus(ticketEventId);
    }


}