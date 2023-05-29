package com.spacebetween.linket.dao.attendance;

import com.spacebetween.linket.dto.AttendanceJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO{
    public static final String NS = "com.spacebetween.linket.mapper.AttendanceMapper.";
    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<Map<String,Object>> getAllAtts(Long eventId) throws Exception {
        return sqlSession.selectList(NS+"getAllAtts", eventId);
    }

    @Override
    public int startBnt(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return sqlSession.update(NS+"startBnt",attendanceJoinDto);
    }

    @Override
    public int endBnt(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return sqlSession.update(NS+"endBnt",attendanceJoinDto);
    }

    @Override
    public Map<String,Object> getMyAtt(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return sqlSession.selectOne(NS+"getMyAtt", attendanceJoinDto);
    }

    @Override
    public int startOfWork(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return sqlSession.update(NS+"startOfWork", attendanceJoinDto);
    }

    @Override
    public int endOfWork(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return sqlSession.update(NS+"endOfWork", attendanceJoinDto);
    }

    @Override
    public List<Map<String, Object>> getHireAllAtts(long attHireId) throws Exception {
        return sqlSession.selectList(NS+"getHireAllAtts", attHireId);
    }

    @Override
    public List<Map<String, Object>> getHireMyAtts(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return sqlSession.selectList(NS+"getHireMyAtts", attendanceJoinDto);
    }

    @Override
    public Map<String,Object> getHire(long eventId) throws Exception {
        return sqlSession.selectOne(NS+"getHire",eventId);
    }

    @Override
    public int joinPtHire(Map<String,Object> map) throws Exception{
        return sqlSession.insert(NS+"joinPtHire",map);
    }

    @Override
    public List<Map<String,Object>> getPtHires(String email) throws Exception {
        return sqlSession.selectList(NS+"getPtHires", email);
    }

    @Override
    public int deletePtHire(AttendanceJoinDto attendanceJoinDto) throws Exception {
        return sqlSession.delete(NS+"deletePtHire", attendanceJoinDto);
    }
}
