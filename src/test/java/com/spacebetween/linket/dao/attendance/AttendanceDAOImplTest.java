package com.spacebetween.linket.dao.attendance;

import com.spacebetween.linket.dto.AttendanceJoinDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AttendanceDAOImplTest {
    @Autowired
    private AttendanceDAO attendanceDAO;

    //Staff가 Part 직원들의 출근 여부를 조회하는 테스트
    @Test
    public void testGetAllAtts() throws Exception{
        List<AttendanceJoinDto> attList = attendanceDAO.getAllAtts();
        System.out.println("attList");
        System.out.println(attList);
    }

    //Part 직원이 자신의 출근 현황을 조회하는 테스트
    @Test
    public void testGetMyAtt() throws Exception{
        List<AttendanceJoinDto> attList = attendanceDAO.getMyAtt("ddd@ddd.com");
        System.out.println(attList);
    }
}