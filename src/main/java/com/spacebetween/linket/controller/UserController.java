package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.UserJoinDto;
import com.spacebetween.linket.exception.ErrorCode;
import com.spacebetween.linket.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private static HttpHeaders header;
    static{
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<Map<String,Object>> getUser(HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");
        Map<String,Object> map = userService.getUser(email);

        if("aaa@aaa.com".equals(map.get("email"))) {
            if(map.get("agreement").equals("1"))
                map.put("agreement", new Boolean(true));
            else
                map.put("agreement", new Boolean(false));

            return new ResponseEntity<>(map, header, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,header, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{password}")
    public ResponseEntity<Map<String,Object>> checkUserPwd(@PathVariable String password, HttpSession session) throws Exception{
        //session에서 얻어온 email 정보
        String sessionEmail = (String)session.getAttribute("email");
        //session에서 얻어온 password 정보
        String sessionPassword = (String)session.getAttribute("password");

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("email", sessionEmail);
        hashMap.put("password", sessionPassword);

        Map<String,Object> map = userService.checkUserPwd(hashMap);
        if(password.equals(map.get("password"))){ // password 확인 성공
            if(map.get("agreement").equals("1"))
                map.put("agreement", new Boolean(true));
            else
                map.put("agreement", new Boolean(false));

            return new ResponseEntity<>(map, header, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/user/{phone}")
    public ResponseEntity<String> updateUserPhone(@PathVariable String phone, HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("email", email);
        hashMap.put("phone", phone);

        int rowCnt = userService.updateUserPhone(hashMap);

        if(rowCnt==1){
            String success = new String("success");
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else {
            String fail = new String("fail");
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user/{password}")
    public ResponseEntity<String> updateUserPassword(@PathVariable String password, HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("email", email);
        hashMap.put("password", password);

        int rowCnt = userService.updateUserPassword(hashMap);

        if(rowCnt==1){
            String success = new String("success");
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else {
            String fail = new String("fail");
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }
    }
}
