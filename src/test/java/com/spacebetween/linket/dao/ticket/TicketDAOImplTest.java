package com.spacebetween.linket.dao.ticket;


import com.spacebetween.linket.dto.TicketJoinDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TicketDAOImplTest {
    @Autowired
    TicketDAO ticketDAO;

    //티켓 생성 테스트
    @Test
    public void testRegisterTicket() throws Exception{
        TicketJoinDto ticketJoinDto = new TicketJoinDto();
        ticketJoinDto.setEmail("staff@test.com");
        ticketJoinDto.setTicketId(10L);

        int rowCnt = ticketDAO.registerTicket(ticketJoinDto);
        assertTrue(rowCnt==1);
    }

    //티켓 전체 조회 테스트
    @Test
    public void testGetAllTickets() throws Exception{
        List<TicketJoinDto> ticketList = ticketDAO.getAllTickets("member@test.com");
        System.out.println();

        for(TicketJoinDto ticketJoinDto : ticketList)
            System.out.println(ticketJoinDto);

    }

    //티켓 단일 조회 테스트
    @Test
    public void getTicket() throws Exception{
        TicketJoinDto ticketJoinDto = ticketDAO.getTicket(1L);
        System.out.println(ticketJoinDto);
    }

    //티켓 삭제 테스트
    @Test
    public void deleteTicket() throws Exception {
        TicketJoinDto ticketJoinDto = new TicketJoinDto();
        ticketJoinDto.setTicketId(10L);
        ticketJoinDto.setTicketStatus('N');

        int rowCnt = ticketDAO.deleteTicket(ticketJoinDto);
        assertTrue(rowCnt == 1);
    }
}
