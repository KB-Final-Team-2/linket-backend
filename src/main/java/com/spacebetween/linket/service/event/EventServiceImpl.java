package com.spacebetween.linket.service.event;

import com.spacebetween.linket.dao.event.EventDAO;
import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDAO eventDAO;

    @Override
    public int registerEvent(EventJoinDto eventJoinDto) throws Exception {
        return eventDAO.registerEvent(eventJoinDto);
    }

    @Override
    public int updateEvent(EventJoinDto eventJoinDto) throws Exception {
        return eventDAO.updateEvent(eventJoinDto);
    }

    @Override
    public int deleteEvent(EventJoinDto eventJoinDto) throws Exception {
        return eventDAO.deleteEvent(eventJoinDto);
    }

    @Override
    public List<Map<String, Object>> getAllEvents(Long companyId) throws Exception {
        return eventDAO.getAllEvents(companyId);
    }

    @Override
    public Map<String, Object> getEvent(Long eventId) throws Exception {
        return eventDAO.getEvent(eventId);
    }

    @Override
    public int registerHire(HireJoinDto hireJoinDto) throws Exception {
        return eventDAO.registerHire(hireJoinDto);
    }

    @Override
    public List<Map<String, Object>> getAllHires(Long eventId) throws Exception {
        return eventDAO.getAllHires(eventId);
    }

    @Override
    public Map<String, Object> getHire(Long hireId) throws Exception {
        return eventDAO.getHire(hireId);
    }

    @Override
    public int deleteHire(Long hireId) throws Exception {
        return eventDAO.deleteHire(hireId);
    }

    @Override
    public int selectUsers(Long eventId) throws Exception {
        return eventDAO.selectUsers(eventId);
    }

    @Override
    public Map<String, Object> selCloseEvent(Long eventId) throws Exception {
        return eventDAO.selCloseEvent(eventId);
    }

    @Override
    public List<Map<String, Object>> getEventIdHire(Long eventId) throws Exception {
        return eventDAO.getEventIdHire(eventId);
    }

    @Override
    public int countUser(Map<String, Object> map) throws Exception {
        return eventDAO.countUser(map);
    }

    @Override
    public String selectPlaceId(EventJoinDto eventJoinDto) throws Exception{
        return eventDAO.selectPlaceId(eventJoinDto);
    }

}
