package com.spacebetween.linket.controller;

import com.spacebetween.linket.dto.UserJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.nio.charset.Charset;
import java.util.Random;

@RestController
@RequestMapping("/api/auth")
public class MailController {

    @Autowired
    private JavaMailSender mailSender;

    private static HttpHeaders header;
    static {
        header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    // mailSending 코드
    @GetMapping("/check-mail/")
    public ResponseEntity<String> mailSending(@RequestBody UserJoinDto userJoinDto) {
        String email = userJoinDto.getEmail();
        System.out.println("이메일 전송");

        //난수 생성(인증번호)
        Random r = new Random();
        int num = r.nextInt(888888) + 111111;  //111111 ~ 999999
        System.out.println("인증번호:" + num);

        /* 이메일 보내기 */
        String setFrom = "skybluelion96@naver.com"; //보내는 이메일
        String toMail = email; //받는 사람 이메일
        String title = "LINKET 회원가입 인증번호 발송 이메일입니다.";
        String content =
                "LINKET 홈페이지를 방문해주셔서 감사합니다." +
                        "<br><br>" +
                        "인증 번호는 " + num + "입니다." +
                        "<br>" +
                        "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        System.out.println(toMail);
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            String result = Integer.toString(num);
            return new ResponseEntity<>(result, header, HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
            String result = "fail";
            return new ResponseEntity<>(result, header, HttpStatus.BAD_REQUEST);
        }
    }
}
