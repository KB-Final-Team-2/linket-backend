package com.spacebetween.linket.service.attendance;

import com.spacebetween.linket.dao.attendance.AttendanceDAO;
import com.spacebetween.linket.dto.AttendanceJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    private AttendanceDAO attendanceDAO;

    @Override
    public List<AttendanceJoinDto> getAllAtts() throws Exception {
        return attendanceDAO.getAllAtts();
    }

    @Override
    public List<AttendanceJoinDto> getMyAtt(String email) throws Exception {
        return attendanceDAO.getMyAtt(email);
    }
}
