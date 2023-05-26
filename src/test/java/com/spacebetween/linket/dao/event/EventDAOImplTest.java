package com.spacebetween.linket.dao.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EventDAOImplTest {

    @Autowired
    EventDAO eventDAO;

    //
//    // Staff가 행사 등록 Test O
//    @Test
//    public void registerEvent() throws Exception {
//        EventJoinDto eventJoinDto
//                = new EventJoinDto("해리포터", "마술쇼"
//                , "2020 - 10 - 10", "2020 - 10 - 12", "String place"
//                , "String eventInq", "eventImage", "desc"
//                , "11", "11", "링크링크링크");
//
//        int rowCnt = eventDAO.registerEvent(eventJoinDto);
//
//        assertTrue(rowCnt == 1);
//    }
//
//    // Staff가 행사 수정 Test O
//    @Test
//    public void updateEvent() throws Exception {
//        EventJoinDto eventJoinDto
//                = new EventJoinDto("수정해리포터", "콘서트", "String place"
//                , "event_image", "String eventDesc", "String eventInq"
//                , "2020 - 10 - 11", "2020 - 10 - 13", "11", "3링크링크");
//
//        int rowCnt = eventDAO.updateEvent(eventJoinDto);
//        assertTrue(rowCnt == 1);
//    }
//
//    // Staff가  등록한 모든 행사 조회 Test O
//    @Test
//    public void getAllEvents() throws Exception {
//        List<Map<String, String>> eventList = eventDAO.getAllEvents(999L);
//
//        for (Map<String, String> eventJoinDto : eventList) {
//            System.out.println(eventJoinDto);
//        }
//    }
//
// Staff가  등록한 행사 상세 조회 Test O
//    @Test
//    public void getEvent() throws Exception {
//        EventJoinDto eventJoinDto = eventDAO.getEvent(235L);
//        System.out.println(eventJoinDto);
//    }
//
//    // Staff가 행사 삭제 Test O
//    @Test
//    public void deleteEvent() throws Exception {
//        EventJoinDto eventJoinDto = new EventJoinDto();
//        eventJoinDto.setEventId(234L);
//
//        int rowCnt = eventDAO.deleteEvent(eventJoinDto);
//        assertTrue(rowCnt == 1);
//    }
//
//    //공고
//    // Staff가 공고 등록 Test O
//    @Test
//    public void registerHire() throws Exception {
//        HireJoinDto hireJoinDto
//                = new HireJoinDto(235L, 111L, "4String workName", 11
//                , "2022-12-30", "2022-12-31", 10000, "edueduedu", LocalDateTime.now());
//
//        int rowCnt = eventDAO.registerHire(hireJoinDto);
//        assertTrue(rowCnt == 1);
//    }
//
//    // Staff가 등록한 공고 전체 조회 Test
//    @Test
//    public void getAllHires() throws Exception {
//        List<Map<String, String>> hireList = eventDAO.getAllHires(123L);
//
//        for (Map<String, String> hireJoinDto : hireList) {
//            System.out.println(hireJoinDto);
//        }
//    }
//
//    // Staff가 공고 상세 조회 Test
//    @Test
//    public void getHire() throws Exception {
//        Map<String, String> hireJoinDto = eventDAO.getHire(666L);
//        System.out.println(hireJoinDto);
//    }
//
//
//    // Staff가 공고 선택 삭제 Test
//    @Test
//    public void deleteHire() throws Exception {
//        int rowCnt = eventDAO.deleteHire(670L);
//        assertTrue(rowCnt == 1);
//
//    }
//
    @Test
    public void testReviewController() throws Exception {
        Map<String, Object> map1 = eventDAO.selCloseEvent(236L);
        System.out.println(map1);
        List<Map<String, Object>> list = eventDAO.getEventIdHire(236L);

        long pay = 0;
        long workHour = 0;
        for(Map<String,Object> map : list) {
            System.out.println(map);
            pay += (long)map.get("pay");
            workHour += (int)map.get("work_hour");
        }

        String startDay = ((String) map1.get("start_date"));
        String endDay = ((String) map1.get("end_date"));

        Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDay);
        Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDay);

        long diffSec = (format2.getTime() - format1.getTime()) / 1000;
        long diffDays = diffSec / (24 * 60 * 60) + 1;

        System.out.println("등록일자:" + map1.get("DATE_FORMAT(reg_date, '%Y-%m-%d-%H-%i')"));
        System.out.println("행사 기간:" + map1.get("event_id"));
        System.out.println("행사 장소:" + map1.get("place"));

        Map<String, Object> hashMap1 = new HashMap<>();
        hashMap1.put("role", "member");
        hashMap1.put("eventId", 236);
        int countMember = eventDAO.countUser(hashMap1);
        System.out.println("관람객 인원:"+countMember);

        Map<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("role", "part");
        hashMap2.put("eventId", 236);
        int countPart = eventDAO.countUser(hashMap2);
        System.out.println("파트타임 인원:" + countPart);

        int countUser = countMember + countPart;
        System.out.println("총 인원:"+countUser);

        long totalPay = countUser * pay * workHour * diffDays;
        System.out.println("총 인건비:" + totalPay);
        System.out.println("행사 설명:" + map1.get("event_desc"));
    }


}
