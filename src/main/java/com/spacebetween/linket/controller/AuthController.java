package com.spacebetween.linket.controller;

import com.spacebetween.linket.domain.User;
import com.spacebetween.linket.dto.UserJoinDto;
import com.spacebetween.linket.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static HttpHeaders header;
    static{
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserJoinDto> signup(@ModelAttribute UserJoinDto userJoinDto) throws Exception{
        int rowCnt = authService.signup(userJoinDto);

        if(rowCnt==1) // 회원가입 성공
            return new ResponseEntity<>(userJoinDto, header, HttpStatus.OK);

        else // 회원가입 실패 (client가 정보 잘못 입력)
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<UserJoinDto> login(String email, String password, HttpSession session, Model model) throws Exception{
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("email",email);
        hashMap.put("password", password);

        UserJoinDto userJoinDto = authService.login(hashMap);

        if(email.equals(userJoinDto.getEmail()) &&
            password.equals(userJoinDto.getPassword())){ //로그인 성공
            session.setAttribute("email",email);

            //test
            //System.out.println(userJoinDto.getEmail()+" "+userJoinDto.getPassword());
            return new ResponseEntity<>(userJoinDto, header, HttpStatus.OK);
        }
        else // 로그인 실패
            return new ResponseEntity<>(null, header, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/check-email")
    public ResponseEntity<String> checkEmail(String email) throws Exception{
        UserJoinDto userJoinDto = authService.checkEmail(email);

        if(email.equals(userJoinDto.getEmail())){
            String success = new String("success");
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/logout")
    public UserJoinDto logout(HttpSession session){
        //로그인 후 User쪽 기능에서 getUser(로그인 후 자신 정보 가져오는 기능) 기능
        //추후에 작성 후에 getUser 메서드를 통해 UserJoinDto를 가져온다

        //세션 종료 (로그아웃)
        session.invalidate();

        return null;
    }

    @GetMapping("/withdrawal")
    public ResponseEntity<String> withdrawal(HttpSession session) throws Exception{
        String email = (String)session.getAttribute("email");

        int rowCnt = authService.deleteUser(email);
        if(rowCnt==1){ // 탈퇴 성공
            session.invalidate();
            String success = new String("success");
            return new ResponseEntity<>(success, header, HttpStatus.OK);
        }
        else{
            String fail = new String("fail");
            return new ResponseEntity<>(fail, header, HttpStatus.BAD_REQUEST);
        }
    }
}
