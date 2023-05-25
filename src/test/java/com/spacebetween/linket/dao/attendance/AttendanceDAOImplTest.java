package com.spacebetween.linket.dao.attendance;

import com.spacebetween.linket.domain.Hire;
import com.spacebetween.linket.dto.AttendanceJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AttendanceDAOImplTest {
    @Autowired
    private AttendanceDAO attendanceDAO;

    @Test
    public void testGetAllAtts() throws Exception{
        List<Map<String,Object>> list = attendanceDAO.getAllAtts(5L);
        for(Map<String,Object> map : list)
            System.out.println(map);
    }

    @Test
    public void testStartBnt() throws Exception{
        AttendanceJoinDto attendanceJoinDto = new AttendanceJoinDto();
        attendanceJoinDto.setAttStartBnt('Y');
        attendanceJoinDto.setEventId(5L);
        attendanceJoinDto.setAttDate("2022-11-11");

        int rowCnt = attendanceDAO.startBnt(attendanceJoinDto);
        assertTrue(rowCnt==1);
    }

    @Test
    public void testEndBnt() throws Exception{
        AttendanceJoinDto attendanceJoinDto = new AttendanceJoinDto();
        attendanceJoinDto.setAttEndBnt('Y');
        attendanceJoinDto.setEventId(5L);
        attendanceJoinDto.setAttDate("2022-11-11");

        int rowCnt = attendanceDAO.endBnt(attendanceJoinDto);
        assertTrue(rowCnt==1);
    }

    @Test
    public void testGetMyAtt() throws Exception{
        AttendanceJoinDto attendanceJoinDto = new AttendanceJoinDto();
        attendanceJoinDto.setEmail("bbb@bbb.com");
        attendanceJoinDto.setEventId(5L);
        attendanceJoinDto.setAttDate("2022-12-30");

        Map<String,Object> att = attendanceDAO.getMyAtt(attendanceJoinDto);
        System.out.println(att);
    }

    @Test
    public void testStartOfWork() throws Exception{
        AttendanceJoinDto attendanceJoinDto = new AttendanceJoinDto();
        attendanceJoinDto.setEmail("aaa@aaa.com");
        attendanceJoinDto.setEventId(5L);
        int rowCnt = attendanceDAO.startOfWork(attendanceJoinDto);
        assertTrue(rowCnt==1);
    }

    @Test
    public void testEndOfWork() throws Exception{
        AttendanceJoinDto attendanceJoinDto = new AttendanceJoinDto();
        attendanceJoinDto.setEmail("aaa@aaa.com");
        attendanceJoinDto.setEventId(5L);
        int rowCnt = attendanceDAO.endOfWork(attendanceJoinDto);
        assertTrue(rowCnt==1);
    }

    @Test
    public void testGetHire() throws Exception{
        Map<String,Object> map = attendanceDAO.getHire(3L);
        System.out.println(map);
    }

    @Test
    public void testJoinPtHire() throws Exception{
        Map<String,Object> map = attendanceDAO.getHire(3L);
        System.out.println(map);
        String workStartDay = (String)map.get("work_start_day");
        String workEndDay = (String)map.get("work_end_day");

        int startDayYear = Integer.parseInt(workStartDay.substring(0,4));
        int startDayMonth = Integer.parseInt(workStartDay.substring(5,7));
        int startDayDay = Integer.parseInt(workStartDay.substring(8,10));

        int endDayYear = Integer.parseInt(workEndDay.substring(0,4));
        int endDayMonth = Integer.parseInt(workEndDay.substring(5,7));
        int endDayDay = Integer.parseInt(workEndDay.substring(8,10));

        while(true){
            String calDay = startDayYear+"-"+startDayMonth+"-"+startDayDay;
            Map<String,Object> temp = new HashMap<>();

            temp.put("att_id", map.get("hire_id"));
            temp.put("att_event_id", map.get("hire_event_id"));
            temp.put("att_company_id", map.get("hire_company_id"));
            temp.put("att_hire_id", "3");
            temp.put("att_email", "bbb@bbb.com");
            temp.put("att_date", calDay);
            temp.put("att_start_datetime", null);
            temp.put("att_end_datetime",null);
            temp.put("att_start_bnt", "N");
            temp.put("att_end_bnt", "N");

            int rowCnt = attendanceDAO.joinPtHire(temp);

            if(startDayYear==endDayYear && startDayMonth==endDayMonth && startDayDay==endDayDay)
                break;

            startDayDay++;

            if(check(startDayMonth,startDayDay)){
                startDayMonth++;
                startDayDay = 1;

                if(startDayMonth>12){
                    startDayYear++;
                    startDayMonth = 1;
                    startDayDay = 1;
                }
            }
        }
    }

    @Test
    public void testGetPtHires() throws Exception{
        List<Map<String,Object>> list = attendanceDAO.getPtHires("bbb@bbb.com");
        for(Map<String,Object> map : list)
            System.out.println(map);
    }

    @Test
    public void testDeletePtHire() throws Exception{
        AttendanceJoinDto attendanceJoinDto = new AttendanceJoinDto();
        attendanceJoinDto.setEmail("bbb@bbb.com");
        attendanceJoinDto.setEventId(5L);
        attendanceJoinDto.setHireId(3L);

        int rowCnt = attendanceDAO.deletePtHire(attendanceJoinDto);
        assertTrue(rowCnt > 0);
    }

    static private boolean check(int month, int day){
        if(month==1 && day > 31){
            return true;
        }
        else if(month==2 && day > 28){
            return true;
        }
        else if(month==3 && day > 31){
            return true;
        }
        else if(month==4 && day > 30){
            return true;
        }
        else if(month==5 && day > 31){
            return true;
        }
        else if(month==6 && day > 30){
            return true;
        }
        else if(month==7 && day > 31){
            return true;
        }
        else if(month==8 && day > 31){
            return true;
        }
        else if(month==9 && day > 30){
            return true;
        }
        else if(month==10 && day > 31){
            return true;
        }
        else if(month==11 && day > 30){
            return true;
        }
        else if(month==12 && day > 31){
            return true;
        }

        return false;
    }
}