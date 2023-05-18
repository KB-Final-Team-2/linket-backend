package com.spacebetween.linket.dao.auth;

import com.spacebetween.linket.dto.UserJoinDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AuthDAOImplTest {
    @Autowired
    AuthDAO authDAO;

    //회원가입 테스트
    @Test
    public void testSignup() throws Exception{
        UserJoinDto userJoinDto = new UserJoinDto("eee@eee.com","1234","doyeon","1999-07-01",1,"010-1111-1111",'F',"staff", LocalDateTime.now(),LocalDateTime.now(),'N',LocalDateTime.now(),1);
        int rowCnt = authDAO.signup(userJoinDto);
        assertTrue(rowCnt==1);
    }

    //로그인 테스트
    @Test
    public void testLogin() throws Exception{
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("email","aaa@aaa.com");
        hashMap.put("password","1234");
        UserJoinDto userJoinDto = authDAO.login(hashMap);

        System.out.println("email:"+userJoinDto.getEmail());
        System.out.println("password:"+userJoinDto.getPassword());

        assertTrue(userJoinDto.getEmail().equals("aaa@aaa.com") &&
                userJoinDto.getPassword().equals("1234"));
    }

    //이메일 중복 체크 테스트
    @Test
    public void testCheckEmail() throws Exception{
        UserJoinDto userJoinDto = authDAO.checkEmail("aaa@aaa.com");

        System.out.println(userJoinDto.getEmail());
        assertTrue(userJoinDto.getEmail().equals("aaa@aaa.com"));
    }
}