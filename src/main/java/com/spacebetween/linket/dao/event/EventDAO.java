package com.spacebetween.linket.dao.event;

import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;

import java.util.List;
import java.util.Map;

public interface EventDAO {

    int registerEvent(EventJoinDto eventJoinDto) throws Exception;

    int updateEvent(EventJoinDto eventJoinDto) throws Exception;

    int deleteEvent(EventJoinDto eventJoinDto) throws Exception;

    List<Map<String, String>> getAllEvents(long companyId) throws Exception;

    Map<String, String> getEvent(long eventId) throws Exception;

    int registerHire(HireJoinDto hireJoinDto) throws Exception;

    List<Map<String, String>> getAllHires(long eventId) throws Exception;

    Map<String, String> getHire(long hireId) throws Exception;

    int deleteHire(long hireId) throws Exception;

    //도연추가
    int selectUsers(Long eventId) throws Exception;

    EventJoinDto selCloseEvent(Long eventId) throws Exception;

    HireJoinDto getEventIdHire(Long eventId) throws Exception;

    //openapi 부분
    String selectPlaceId(EventJoinDto eventJoinDto) throws Exception;
}
