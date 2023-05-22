package com.spacebetween.linket.dao.event;

import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EventDAOImpl implements EventDAO {

    public static final String NS = "com.spacebetween.linket.mapper.EventMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int registerEvent(EventJoinDto eventJoinDto) throws Exception {
        return sqlSession.insert(NS + "registerEvent", eventJoinDto);
    }

    @Override
    public int updateEvent(EventJoinDto eventJoinDto) throws Exception {
        return sqlSession.update(NS + "updateEvent", eventJoinDto);
    }

    @Override
    public int deleteEvent(EventJoinDto eventJoinDto) throws Exception {
        return sqlSession.update(NS + "deleteEvent", eventJoinDto);
    }

    @Override
    public List<Map<String, String>> getAllEvents(long companyId) throws Exception {
        return sqlSession.selectList(NS + "getAllEvents", companyId);
    }

    @Override
    public Map<String, String> getEvent(long eventId) throws Exception {
        return sqlSession.selectOne(NS + "getEvent", eventId);
    }

    @Override
    public int registerHire(HireJoinDto hireJoinDto) throws Exception {
        return sqlSession.insert(NS + "registerHire", hireJoinDto);
    }

    @Override
    public List<Map<String, String>> getAllHires(long eventId) throws Exception {
        return sqlSession.selectList(NS + "getAllHires", eventId);
    }

    @Override
    public Map<String, String> getHire(long hireId) throws Exception {
        return sqlSession.selectOne(NS + "getHire", hireId);
    }

    @Override
    public int deleteHire(long hireId) throws Exception {
        return sqlSession.delete(NS + "deleteHire", hireId);
    }

    //도연추가
    @Override
    public int selectUsers(Long eventId) throws Exception {
        return sqlSession.selectOne(NS + "selectUsers", eventId);
    }

    @Override
    public EventJoinDto selCloseEvent(Long eventId) throws Exception {
        return sqlSession.selectOne(NS + "selCloseEvent", eventId);
    }

    @Override
    public HireJoinDto getEventIdHire(Long eventId) throws Exception {
        return sqlSession.selectOne(NS + "getEventIdHire", eventId);
    }

}
