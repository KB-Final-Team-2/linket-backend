package com.spacebetween.linket.service.event;

import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;

import java.util.List;
import java.util.Map;

public interface EventService {
    int registerEvent(EventJoinDto eventJoinDto) throws Exception;

    int updateEvent(EventJoinDto eventJoinDto) throws Exception;

    int deleteEvent(EventJoinDto eventJoinDto) throws Exception;

    List<Map<String, Object>> getAllEvents(Long companyId) throws Exception;

    Map<String, Object> getEvent(Long eventId) throws Exception;

    int registerHire(HireJoinDto hireJoinDto) throws Exception;

    List<Map<String, Object>> getAllHires(Long eventId) throws Exception;

    Map<String, Object> getHire(Long hireId) throws Exception;

    int deleteHire(Long hireId) throws Exception;

    int selectUsers(Long eventId) throws Exception;

    Map<String, Object> selCloseEvent(Long eventId) throws Exception;

    List<Map<String, Object>> getEventIdHire(Long eventId) throws Exception;

    int countUser(Map<String, Object> map) throws Exception;

    //openapi 부분
    String selectPlaceId(EventJoinDto eventJoinDto) throws Exception;
}
