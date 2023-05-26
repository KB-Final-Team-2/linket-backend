package com.spacebetween.linket.controller;

import com.fasterxml.jackson.core.ObjectCodec;
import com.spacebetween.linket.dto.AttendanceJoinDto;
import com.spacebetween.linket.service.attendance.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
    private static HttpHeaders header;

    static {
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping("/staff/{eventId}")
    public ResponseEntity<List<Map<String,Object>>> getAllAtts(@PathVariable Long eventId) throws Exception {
        List<Map<String,Object>> list = attendanceService.getAllAtts(eventId);

        for(Map<String,Object> map : list){
            String startStr = (String)map.get("att_start_bnt");
            String endStr = (String)map.get("att_end_bnt");

            if(startStr.equals("N"))
                map.put("att_start_bnt", new Boolean("false"));
            else
                map.put("att_start_bnt", new Boolean("true"));

            if(endStr.equals("N"))
                map.put("att_end_bnt", new Boolean("false"));
            else
                map.put("att_end_bnt", new Boolean("true"));
        }

        if (list != null)
            return new ResponseEntity<>(list, header, HttpStatus.OK);

        else
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/staff/start")
    public ResponseEntity<String> startBnt(@RequestBody AttendanceJoinDto attendanceJoinDto) throws Exception{
        int rowCnt = attendanceService.startBnt(attendanceJoinDto);

        if(rowCnt==1){
            String success = new String("success");
            return new ResponseEntity<>(success,header,HttpStatus.OK);
        }
        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail,header,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/staff/end")
    public ResponseEntity<String> endBnt(@RequestBody AttendanceJoinDto attendanceJoinDto) throws Exception{
        int rowCnt = attendanceService.endBnt(attendanceJoinDto);

        if(rowCnt==1){
            String success = new String("success");
            return new ResponseEntity<>(success,header,HttpStatus.OK);
        }
        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail,header,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/part-time/{hireId}")
    public ResponseEntity<Map<String, Object>> getMyAtt(@PathVariable Long hireId, @RequestBody AttendanceJoinDto attendanceJoinDto, HttpSession session) throws Exception{
        attendanceJoinDto.setEmail((String)session.getAttribute("email"));
        attendanceJoinDto.setEventId(hireId);

        Map<String,Object> map = attendanceService.getMyAtt(attendanceJoinDto);
        String startStr = (String)map.get("att_start_bnt");
        String endStr = (String)map.get("att_end_bnt");

        if(startStr.equals("N"))
            map.put("att_start_bnt", new Boolean(false));
        else
            map.put("att_start_bnt", new Boolean(true));

        if(endStr.equals("N"))
            map.put("att_end_bnt", new Boolean(false));
        else
            map.put("att_end_bnt", new Boolean(true));


        if(map!=null)
            return new ResponseEntity<>(map,header,HttpStatus.OK);
        else
            return new ResponseEntity<>(null,header,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/part-time/start")
    public ResponseEntity<String> startOfWork(@RequestBody AttendanceJoinDto attendanceJoinDto, HttpSession session) throws Exception{
//        attendanceJoinDto.setEmail((String)session.getAttribute("email"));
        int rowCnt = attendanceService.startOfWork(attendanceJoinDto);

        if(rowCnt==1){
            String success = new String("success");
            return new ResponseEntity<>(success,header,HttpStatus.OK);
        }
        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail,header,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/part-time/end")
    public ResponseEntity<String> endOfWork(@RequestBody AttendanceJoinDto attendanceJoinDto, HttpSession session) throws Exception{
//        attendanceJoinDto.setEmail((String)session.getAttribute("email"));
        int rowCnt = attendanceService.endOfWork(attendanceJoinDto);

        if(rowCnt==1){
            String success = new String("success");
            return new ResponseEntity<>(success,header,HttpStatus.OK);
        }
        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail,header,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/join/{hireId}")
    public ResponseEntity<String> joinPtHire(@PathVariable Long hireId, HttpSession session) throws Exception {
        Map<String, Object> map = attendanceService.getHire(hireId);

        String workStartDay = (String) map.get("work_start_day");
        String workEndDay = (String) map.get("work_end_day");

        int startDayYear = Integer.parseInt(workStartDay.substring(0, 4));
        int startDayMonth = Integer.parseInt(workStartDay.substring(5, 7));
        int startDayDay = Integer.parseInt(workStartDay.substring(8, 10));

        int endDayYear = Integer.parseInt(workEndDay.substring(0, 4));
        int endDayMonth = Integer.parseInt(workEndDay.substring(5, 7));
        int endDayDay = Integer.parseInt(workEndDay.substring(8, 10));

        int count = 0;
        while (true) {
            String calDay = startDayYear + "-" + startDayMonth + "-" + startDayDay;
            Map<String, Object> temp = new HashMap<>();

            temp.put("att_id", map.get("hire_id"));
            temp.put("att_event_id", map.get("hire_event_id"));
            temp.put("att_company_id", map.get("hire_company_id"));
            temp.put("att_hire_id", String.valueOf(hireId));
            temp.put("att_email", (String)session.getAttribute("email"));
            temp.put("att_date", calDay);
            temp.put("att_start_datetime", null);
            temp.put("att_end_datetime", null);
            temp.put("att_start_bnt", "N");
            temp.put("att_end_bnt", "N");

            int rowCnt = attendanceService.joinPtHire(temp);
            if(rowCnt == 1)
                count++;

            if (startDayYear == endDayYear && startDayMonth == endDayMonth && startDayDay == endDayDay)
                break;

            startDayDay++;

            if (check(startDayMonth, startDayDay)) {
                startDayMonth++;
                startDayDay = 1;

                if (startDayMonth > 12) {
                    startDayYear++;
                    startDayMonth = 1;
                    startDayDay = 1;
                }
            }
        }
        if(count>0){
            String success = new String("success");
            return new ResponseEntity<>(success,header,HttpStatus.OK);
        }

        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail,header,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/part-time/{email}")
    public ResponseEntity<List<Map<String,Object>>> getPtHires(@PathVariable String email) throws Exception{
        email += ".com";
        List<Map<String,Object>> list = attendanceService.getPtHires(email);

        if(list!=null)
            return new ResponseEntity<>(list,header,HttpStatus.OK);
        else
            return new ResponseEntity<>(null,header,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/part-time/{hireId}")
    public ResponseEntity<String> deletePtHire(@PathVariable Long hireId, @RequestBody AttendanceJoinDto attendanceJoinDto, HttpSession session) throws Exception{
//        attendanceJoinDto.setEmail((String)session.getAttribute("email"));
        attendanceJoinDto.setEmail("bbb@bbb.com");
        attendanceJoinDto.setEventId(hireId);

        int rowCnt = attendanceService.deletePtHire(attendanceJoinDto);

        if(rowCnt>0){
            String success = new String("success");
            return new ResponseEntity<>(success,header,HttpStatus.OK);
        }
        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail,header,HttpStatus.BAD_REQUEST);
        }
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
