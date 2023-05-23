package com.spacebetween.linket.service.attendance;

import com.spacebetween.linket.dto.AttendanceJoinDto;

import java.util.List;

public interface AttendanceService {
    List<AttendanceJoinDto> getAllAtts() throws Exception;
    List<AttendanceJoinDto> getMyAtt(String email) throws Exception;
}
