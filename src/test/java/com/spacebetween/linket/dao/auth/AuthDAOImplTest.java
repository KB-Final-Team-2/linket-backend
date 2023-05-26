package com.spacebetween.linket.dao.auth;

import com.spacebetween.linket.dto.UserJoinDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AuthDAOImplTest {
    @Autowired
    AuthDAO authDAO;

    //로그인 테스트
    @Test
    public void testLogin() throws Exception{
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("email","aaa@aaa.com");
        hashMap.put("password","1234");
        Map<String,Object> map = authDAO.login(hashMap);

        System.out.println("email:"+map.get("email"));
        System.out.println("password:"+map.get("password"));

        assertTrue(map.get("email").equals("aaa@aaa.com") &&
                map.get("password").equals("1234"));
    }

    //이메일 중복 체크 테스트
    @Test
    public void testCheckEmail() throws Exception{
        UserJoinDto userJoinDto = authDAO.checkEmail("aaa@aaa.com");

        System.out.println(userJoinDto.getEmail());
        assertTrue(userJoinDto.getEmail().equals("aaa@aaa.com"));
    }

    //사용자 회원 탈퇴 테스트(수정)
    @Test
    public void testUpdateUser() throws Exception{
        int rowCnt = authDAO.updateUser("ccc@ccc.com");
        assertTrue(rowCnt==1);
    }
}