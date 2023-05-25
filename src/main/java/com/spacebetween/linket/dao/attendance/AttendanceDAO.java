package com.spacebetween.linket.dao.attendance;

import com.spacebetween.linket.dto.AttendanceJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;

import java.util.List;
import java.util.Map;

public interface AttendanceDAO {
    List<Map<String,Object>> getAllAtts(Long eventId) throws Exception;
    int startBnt(AttendanceJoinDto attendanceJoinDto) throws Exception;
    int endBnt(AttendanceJoinDto attendanceJoinDto) throws Exception;
    Map<String,Object> getMyAtt(AttendanceJoinDto attendanceJoinDto) throws Exception;
    int startOfWork(AttendanceJoinDto attendanceJoinDto) throws Exception;
    int endOfWork(AttendanceJoinDto attendanceJoinDto) throws Exception;
    //다시 봐야 할 것
    //Part 자신이 참여하는 행사 공고에 등록합니다
    Map<String,Object> getHire(long eventId) throws Exception;
    int joinPtHire(Map<String,Object> map) throws Exception;
    List<Map<String,Object>> getPtHires(String email) throws Exception;
    int deletePtHire(AttendanceJoinDto attendanceJoinDto) throws Exception;
}
