package com.spacebetween.linket.dao.attendance;

import com.spacebetween.linket.dto.AttendanceJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO{
    public static final String NS = "com.spacebetween.linket.mapper.AttendanceMapper.";
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<AttendanceJoinDto> getAllAtts() throws Exception {
        return sqlSession.selectList(NS+"getAllAtts");
    }

    @Override
    public List<AttendanceJoinDto> getMyAtt(String email) throws Exception {
        return sqlSession.selectList(NS+"getMyAtt", email);
    }
}
