package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.UserJoinDto;
import com.spacebetween.linket.service.auth.AuthService;
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
@RequestMapping("/api/auth")
public class AuthController {
    private static HttpHeaders header;
    static {
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserJoinDto userJoinDto) throws Exception{
        int rowCnt = authService.signup(userJoinDto);

        if(rowCnt==1) { // 회원가입 성공
            String success = new String("success");
            return new ResponseEntity<>(success,header,HttpStatus.OK);
        }

        else { // 회원가입 실패 (client가 정보 잘못 입력)
            String fail = new String("fail");
            return new ResponseEntity<>(fail, header,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody UserJoinDto userJoinDto, HttpSession session) throws Exception{
      
        HashMap<String,String> hashMap = new HashMap<>();
        String email = userJoinDto.getEmail();
        String password = userJoinDto.getPassword();

        hashMap.put("email", email);
        hashMap.put("password", password);

        Map<String,Object> map = authService.login(hashMap);

        if(email.equals(map.get("email")) &&
                password.equals(map.get("password"))) { //로그인 성공
            session.setAttribute("email", email);
            session.setAttribute("password", password);

            if(map.get("agreement").equals("1"))
                map.put("agreement", new Boolean(true));
            else
                map.put("agreement", new Boolean(false));

            return new ResponseEntity<>(map, header, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
        }
    }
      
    @PostMapping("/check-email")
    public ResponseEntity<String> checkEmail(@RequestBody UserJoinDto userJoinDto) throws Exception{
        String email = userJoinDto.getEmail();
        UserJoinDto passObj = authService.checkEmail(email);

        if(email.equals(userJoinDto.getEmail())){ //이메일이 중복됨
            String success = new String("success");
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else { //이메일이 중복되지 않음
            String fail = new String("fail");
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        //세션 종료 (로그아웃)
        session.invalidate();

        return new ResponseEntity<>(new String("success"),header,HttpStatus.OK);
    }

    @GetMapping("/withdrawal")
    public ResponseEntity<String> withdrawal(HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");

        int rowCnt = authService.updateUser("eee@eee.com");
        if(rowCnt==1){ // 탈퇴 성공
            session.invalidate();
            String success = new String("success");
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else {
            String fail = new String("fail");
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }
    }
}
