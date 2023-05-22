package com.spacebetween.linket.service.event;

import com.spacebetween.linket.dao.event.EventDAO;
import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface EventService {
    int registerEvent(EventJoinDto eventJoinDto) throws Exception;

    int updateEvent(EventJoinDto eventJoinDto) throws Exception;

    int deleteEvent(EventJoinDto eventJoinDto) throws Exception;

    List<Map<String,String>> getAllEvents(long companyId) throws Exception;

    Map<String,String> getEvent(long eventId) throws Exception;

    int registerHire(HireJoinDto hireJoinDto) throws Exception;

    List<Map<String,String>> getAllHires(long eventId) throws Exception;

    Map<String,String> getHire(long hireId) throws Exception;

    int deleteHire(long hireId) throws Exception;

}
