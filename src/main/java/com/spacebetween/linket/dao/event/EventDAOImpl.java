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
    public List<Map<String, Object>> getAllEvents(Long companyId) throws Exception {
        return sqlSession.selectList(NS + "getAllEvents", companyId);
    }

    @Override
    public Map<String, Object> getEvent(Long eventId) throws Exception {
        return sqlSession.selectOne(NS + "getEvent", eventId);
    }

    @Override
    public int registerHire(HireJoinDto hireJoinDto) throws Exception {
        return sqlSession.insert(NS + "registerHire", hireJoinDto);
    }

    @Override
    public List<Map<String, Object>> getAllHires(Long eventId) throws Exception {
        return sqlSession.selectList(NS + "getAllHires", eventId);
    }

    @Override
    public Map<String, Object> getHire(Long hireId) throws Exception {
        return sqlSession.selectOne(NS + "getHire", hireId);
    }

    @Override
    public int deleteHire(Long hireId) throws Exception {
        return sqlSession.delete(NS + "deleteHire", hireId);
    }

    @Override
    public int selectUsers(Long eventId) throws Exception {
        return sqlSession.selectOne(NS + "selectUsers", eventId);
    }

    @Override
    public Map<String, Object> selCloseEvent(Long eventId) throws Exception {
        return sqlSession.selectOne(NS + "selCloseEvent", eventId);
    }

    @Override
    public List<Map<String, Object>> getEventIdHire(Long eventId) throws Exception {
        return sqlSession.selectList(NS + "getEventIdHire", eventId);
    }

    @Override
    public int countUser(Map<String, Object> map) throws Exception {
        return sqlSession.selectOne(NS + "countUser", map);
    }

    //openapi 부분
    @Override
    public String selectPlaceId(EventJoinDto eventJoinDto) throws Exception{
        return sqlSession.selectOne(NS+"selectPlaceId", eventJoinDto);
    }
}
