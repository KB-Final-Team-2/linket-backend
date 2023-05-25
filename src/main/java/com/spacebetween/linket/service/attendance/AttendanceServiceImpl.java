package com.spacebetween.linket.service.attendance;

import com.spacebetween.linket.dao.attendance.AttendanceDAO;
import com.spacebetween.linket.dto.AttendanceJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AttendanceServiceImpl implements AttendanceService{
    @Autowired
    private AttendanceDAO attendanceDAO;


    @Override
    public List<Map<String,Object>> getAllAtts(Long eventId) throws Exception {
        return attendanceDAO.getAllAtts(eventId);
    }

    @Override
    public int startBnt(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return attendanceDAO.startBnt(attendanceJoinDto);
    }

    @Override
    public int endBnt(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return attendanceDAO.endBnt(attendanceJoinDto);
    }

    @Override
    public Map<String,Object> getMyAtt(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return attendanceDAO.getMyAtt(attendanceJoinDto);
    }

    @Override
    public int startOfWork(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return attendanceDAO.startOfWork(attendanceJoinDto);
    }

    @Override
    public int endOfWork(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return attendanceDAO.endOfWork(attendanceJoinDto);
    }

    @Override
    public Map<String,Object> getHire(long eventId) throws Exception {
        return attendanceDAO.getHire(eventId);
    }

    @Override
    public int joinPtHire(Map<String,Object> map) throws Exception{
        return attendanceDAO.joinPtHire(map);
    }

    @Override
    public List<Map<String,Object>> getPtHires(String email) throws Exception {
        return attendanceDAO.getPtHires(email);
    }

    @Override
    public int deletePtHire(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return attendanceDAO.deletePtHire(attendanceJoinDto);
    }
}
