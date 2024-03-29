package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.EventJoinDto;
import com.spacebetween.linket.dto.HireJoinDto;
import com.spacebetween.linket.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/event")
public class EventController {
    static StringBuilder urlBuilder = new StringBuilder("https://www.kopis.or.kr/openApi/restful/prfplc");
    private static HttpHeaders header;

    static {
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private EventService eventService;

    //openapi 부분
    @PostMapping("/{placeName}")
    public ResponseEntity<Map<String, Object>> getInfo(@PathVariable String placeName, @RequestBody EventJoinDto eventJoinDto) throws Exception {
        eventJoinDto.setPlace(placeName);
        String placeId = eventService.selectPlaceId(eventJoinDto);

        System.out.println(placeId);
        urlBuilder.append("/" + URLEncoder.encode(placeId, "UTF-8"));
        urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "="
                + URLEncoder.encode("11653933ac2447da843868e7cb625bdb", "UTF-8"));

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        String result = "";
        String line = "";

        Map<String, Object> answer = new HashMap<String, Object>();

        while ((line = br.readLine()) != null) {
            if (line.contains("<fcltynm>")) {
                line = line.replaceAll("<fcltynm>", "");
                line = line.replaceAll("</fcltynm>", "");
                line = line.trim();

                answer.put("placeName", line);
            } else if (line.contains("<adres>")) {
                line = line.replaceAll("<adres>", "");
                line = line.replaceAll("</adres>", "");
                line = line.trim();

                answer.put("address", line);
            } else if (line.contains("<la>")) {
                line = line.replaceAll("<la>", "");
                line = line.replaceAll("</la>", "");
                line = line.trim();

                double la = Double.parseDouble(line);
                answer.put("latitude", la);
            } else if (line.contains("<lo>")) {
                line = line.replaceAll("<lo>", "");
                line = line.replaceAll("</lo>", "");
                line = line.trim();

                double lo = Double.parseDouble(line);
                answer.put("longitude", lo);
            }
        }

        System.out.println(answer);
        return new ResponseEntity<>(answer, header, HttpStatus.OK);
    }

    //test success
    @PostMapping("/register")
    public ResponseEntity<String> registerEvent(@RequestBody EventJoinDto eventJoinDto) throws Exception {

        int rowCnt = eventService.registerEvent(eventJoinDto);

        if (rowCnt == 1) {
            return new ResponseEntity<>("registerEvent success!~", header, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);

        }
    }

    //Test success
    @GetMapping("/getAllEvents/{eventCompanyId}")
    public ResponseEntity<List<Map<String, Object>>> getAllEvents(@PathVariable Long eventCompanyId) throws Exception {
        // companyId와 일치하는 이벤트들울 보여줌 (종류와 이름)
        try {
            List<Map<String, Object>> eventList = eventService.getAllEvents(eventCompanyId);
            return ResponseEntity.ok().headers(header).body(eventList);

        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);

        }
    }

    //Test success
    @GetMapping("/getEvent/{eventId}")
    public ResponseEntity<Map<String, Object>> getEvent(@PathVariable Long eventId) throws Exception {
        //eventId와 일치하는 이벤트의 상세정보 조회
        try {
            Map<String, Object> eventDetails = eventService.getEvent(eventId);
            return ResponseEntity.ok().headers(header).body(eventDetails);

        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);

        }

    }

    //Test
    @PostMapping("/updateEvent")
    public ResponseEntity<String> updateEvent(@RequestBody EventJoinDto eventJoinDto) throws Exception {
        //eventId로 찾아서 수정, 아니면 예외처리
        int rowCnt = eventService.updateEvent(eventJoinDto);

        if (rowCnt == 1) {
            return new ResponseEntity<>("updateEvent success!~", header, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
        }
    }

    //Test success..
    @PostMapping("/deleteEvent")
    public ResponseEntity<String> deleteEvent(@RequestBody EventJoinDto eventJoinDto) throws Exception {
        //column을 삭제하는 것이 아니라, eventId를 넣어 삭제일자를 수정
        int rowCnt = eventService.deleteEvent(eventJoinDto);

        if (rowCnt == 1) {
            return new ResponseEntity<>("deleteEvent success!~", header, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
        }
    }

    //Test success..
    @PostMapping("/hire/registerHire")
    public ResponseEntity<String> registerHire(@RequestBody HireJoinDto hireJoinDto) throws Exception {

        int rowCnt = eventService.registerHire(hireJoinDto);

        if (rowCnt == 1) {
            return new ResponseEntity<>("registerHire success!~", header, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
        }
    }

    //Test success
    @GetMapping("/hire/getAllHires/{hireEventId}")
    public ResponseEntity<List<Map<String, Object>>> getAllHires(@PathVariable Long hireEventId) throws Exception {
        // eventId와 일치하는 이벤트들울 보여줌 (종류와 이름)
        try {
            List<Map<String, Object>> hireList = eventService.getAllHires(hireEventId);
            return ResponseEntity.ok().headers(header).body(hireList);

        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);

        }
    }

    //Test success
    @GetMapping("/hire/getHire/{hireId}")
    public ResponseEntity<Map<String, Object>> getHire(@PathVariable Long hireId) throws Exception {
        // eventId와 일치하는 이벤트들울 보여줌 (종류와 이름)
        try {
            Map<String, Object> hireDetails = eventService.getHire(hireId);
            return ResponseEntity.ok().headers(header).body(hireDetails);

        } catch (Exception e) {
            return ResponseEntity.status(500).headers(header).body(null);

        }
    }

    //Test success
    @PostMapping("/hire/deleteHire/{hireId}")
    public ResponseEntity<String> deleteHire(@PathVariable Long hireId) throws Exception {

        int rowCnt = eventService.deleteHire(hireId);

        if (rowCnt == 1) {
            return new ResponseEntity<>("deleteHire success!~", header, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
        }
    }


    //Test success
    @GetMapping("/staff/{eventId}/status")
    public ResponseEntity<Map<String, Object>> getEventStatus(@PathVariable Long eventId) throws Exception {
        Map<String, Object> map1 = eventService.selCloseEvent(eventId);
        System.out.println(map1);
        List<Map<String, Object>> list = eventService.getEventIdHire(eventId);

        long pay = 0;
        long workHour = 0;
        for (Map<String, Object> map : list) {
            pay += (long) map.get("pay");
            workHour += (int) map.get("workHour");
        }

        String startDay = ((String) map1.get("startDate"));
        String endDay = ((String) map1.get("endDate"));

        Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDay);
        Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDay);

        long diffSec = (format2.getTime() - format1.getTime()) / 1000;
        long diffDays = diffSec / (24 * 60 * 60) + 1;

        //등록 일자, 행사 기간, 행사 장소, 참여 인원(관람객, 파트타임), 총 인건비, 행사 설명
        Map<String, Object> result = new HashMap<>();
        //등록일자
        result.put("regDate", map1.get("dateFormat(regDate, '%y-%m-%d-%h-%i')"));
        //행사 장소
        result.put("place", map1.get("place"));
        //행사 기간
        result.put("startDate", startDay);
        result.put("endDate", endDay);
        //관람객 인원
        Map<String, Object> hashMap1 = new HashMap<>();
        hashMap1.put("role", "member");
        hashMap1.put("eventId", eventId);

        int countMember = eventService.countUser(hashMap1);
        result.put("countMember", countMember);
        //파트 인원
        Map<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("role", "part");
        hashMap2.put("eventId", eventId);

        int countPart = eventService.countUser(hashMap2);
        result.put("countPart", countPart);
        //총 인원

        int countUser = countMember + countPart;
        result.put("countUser", countUser);

        long totalPay = countUser * pay * workHour * diffDays;
        result.put("totalPay", totalPay);
        result.put("eventDesc", map1.get("eventDesc"));

        return new ResponseEntity<>(result, header, HttpStatus.OK);
    }

}
