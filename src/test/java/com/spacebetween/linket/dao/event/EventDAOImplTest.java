package com.spacebetween.linket.dao.event;

import com.spacebetween.linket.dao.attendance.AttendanceDAO;
import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EventDAOImplTest {

    @Autowired
    EventDAO eventDAO;

    // Staff가 행사 등록 Test O
    @Test
    public void registerEvent() throws Exception {
        EventJoinDto eventJoinDto
                = new EventJoinDto(999L, "해리포터", "마술쇼"
                , "2020 - 10 - 10", "2020 - 10 - 12", "String place"
                , "String eventInq", "eventImage", "desc"
                , LocalDateTime.now(), LocalDateTime.now(), "링크링크링크");

        int rowCnt = eventDAO.registerEvent(eventJoinDto);

        assertTrue(rowCnt == 1);
    }

    // Staff가 행사 수정 Test O
    @Test
    public void updateEvent() throws Exception {
        EventJoinDto eventJoinDto
                = new EventJoinDto(235L, "수정해리포터", "콘서트", "String place"
                , "event_image", "String eventDesc", "String eventInq"
                , "2020 - 10 - 11", "2020 - 10 - 13", LocalDateTime.now(), "3링크링크");

        int rowCnt = eventDAO.updateEvent(eventJoinDto);
        assertTrue(rowCnt == 1);
    }

    // Staff가  등록한 모든 행사 조회 Test O
    @Test
    public void getAllEvents() throws Exception {
        List<Map<String, String>> eventList = eventDAO.getAllEvents(999L);

        for (Map<String, String> eventJoinDto : eventList) {
            System.out.println(eventJoinDto);
        }
    }

    // Staff가  등록한 행사 상세 조회 Test O
    @Test
    public void getEvent() throws Exception {
        Map<String, String> eventJoinDto = eventDAO.getEvent(235L);
        System.out.println(eventJoinDto);
    }

    // Staff가 행사 삭제 Test O
    @Test
    public void deleteEvent() throws Exception {
        EventJoinDto eventJoinDto = new EventJoinDto(234L, 'N', LocalDateTime.now(), LocalDateTime.now());

        int rowCnt = eventDAO.deleteEvent(eventJoinDto);

        assertTrue(rowCnt == 1);
    }

    //공고
    // Staff가 공고 등록 Test O
    @Test
    public void registerHire() throws Exception {
        HireJoinDto hireJoinDto
                = new HireJoinDto(235L, 111L, "4String workName", 11
                , "2022-12-30", "2022-12-31", 10000, "edueduedu", LocalDateTime.now());

        int rowCnt = eventDAO.registerHire(hireJoinDto);
        assertTrue(rowCnt == 1);
    }

    // Staff가 등록한 공고 전체 조회 Test
    @Test
    public void getAllHires() throws Exception {
        List<Map<String, String>> hireList = eventDAO.getAllHires(123L);

        for (Map<String, String> hireJoinDto : hireList) {
            System.out.println(hireJoinDto);
        }
    }

    // Staff가 공고 상세 조회 Test
    @Test
    public void getHire() throws Exception {
        Map<String, String> hireJoinDto = eventDAO.getHire(666L);
        System.out.println(hireJoinDto);
    }


    // Staff가 공고 선택 삭제 Test
    @Test
    public void deleteHire() throws Exception {
        int rowCnt = eventDAO.deleteHire(670L);
        assertTrue(rowCnt == 1);

    }

    //Satff가 종료된 행사중 하나를 선택하여 상세 조회 Test
    @Test
    public void testReviewController() throws Exception{
        int userCnt = eventDAO.selectUsers(3L); // eventId 3에 대한 attendance 인원
        EventJoinDto eventJoinDto = eventDAO.selCloseEvent(3L);

        HireJoinDto hireJoinDto = eventDAO.getEventIdHire(3L);
        int totalPay = userCnt * hireJoinDto.getPay() * hireJoinDto.getWorkHour();

        System.out.println("등록일자:"+eventJoinDto.getRegDate());
        System.out.println("행사 기간:"+eventJoinDto.getEventName());
        System.out.println("행사 장소:"+eventJoinDto.getPlace());
        System.out.println("참여 인원:"+userCnt);
        System.out.println("총 인건비:"+totalPay);
        System.out.println("행사 설명:"+eventJoinDto.getEventDesc());
    }


}
