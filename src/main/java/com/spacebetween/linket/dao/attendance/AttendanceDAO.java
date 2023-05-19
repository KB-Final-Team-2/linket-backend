package com.spacebetween.linket.dao.attendance;

import com.spacebetween.linket.dto.AttendanceJoinDto;

import java.util.List;

public interface AttendanceDAO {
    List<AttendanceJoinDto> getAllAtts() throws Exception;
    List<AttendanceJoinDto> getMyAtt(String email) throws Exception;
}
