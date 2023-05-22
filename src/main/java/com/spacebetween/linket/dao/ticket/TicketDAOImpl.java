package com.spacebetween.linket.dao.ticket;

import com.spacebetween.linket.dto.TicketJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Repository
public class TicketDAOImpl implements TicketDAO{

    public static final String NS = "com.spacebetween.linket.mapper.TicketMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int registerTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return sqlSession.insert(NS+"registerTicket", ticketJoinDto);
    }

    @Override
    public List<Map<String,String>> getAllTickets(String email) throws Exception {
        return sqlSession.selectList(NS+"getAllTickets",email);
    }

    @Override
    public Map<String,String> getTicket(Long ticketId) throws Exception {
        return sqlSession.selectOne(NS+"getTicket",ticketId);
    }

    @Override
    public int deleteTicket(TicketJoinDto ticketJoinDto) throws Exception {
        return sqlSession.delete(NS+"deleteTicket", ticketJoinDto);
    }
}
