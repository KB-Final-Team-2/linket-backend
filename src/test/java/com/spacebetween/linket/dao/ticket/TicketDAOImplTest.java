package com.spacebetween.linket.dao.ticket;


import com.spacebetween.linket.dto.TicketJoinDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TicketDAOImplTest {
    @Autowired
    TicketDAO ticketDAO;


    //티켓 등록여부 테스트
    @Test
    public void testCheckTicket() throws Exception{
        String result = ticketDAO.checkTicket("12345");
        System.out.println(result);
    }

    //티켓 생성 테스트
    @Test
    public void testRegisterTicket() throws Exception{
        TicketJoinDto ticketJoinDto = new TicketJoinDto();
        ticketJoinDto.setEmail("member@test.com");
        ticketJoinDto.setTicketId(2L);

        int rowCnt = ticketDAO.registerTicket(ticketJoinDto);
        assertTrue(rowCnt==1);
    }

    //티켓 전체 조회 테스트
    @Test
    public void testGetAllTickets() throws Exception{
        List<Map<String,Object>> ticketList = ticketDAO.getAllTickets("member@test.com");
        System.out.println();

        for(Map<String,Object> map : ticketList)
            System.out.println(map);

    }

    //티켓 단일 조회 테스트
    @Test
    public void testGetTicket() throws Exception{
        Map<String,Object> ticketMap = ticketDAO.getTicket(1L);
        System.out.println(ticketMap);
    }

    //티켓 삭제 테스트
    @Test
    public void TestDeleteTicket() throws Exception {
        TicketJoinDto ticketJoinDto = new TicketJoinDto();
        ticketJoinDto.setTicketId(2L);
        ticketJoinDto.setTicketStatus("N");

        int rowCnt = ticketDAO.deleteTicket(ticketJoinDto);
        assertTrue(rowCnt == 1);
    }

    @Test
    public void testGetTicketStatus() throws Exception{
        List<Map<String,Object>> ticketList = ticketDAO.getTicketStatus(1L);
        System.out.println();

        for(Map<String,Object> map : ticketList)
            System.out.println(map);
    }
}
