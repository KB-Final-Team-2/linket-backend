package com.spacebetween.linket.service.auth;

import com.spacebetween.linket.dao.auth.AuthDAO;
import com.spacebetween.linket.dto.UserJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    AuthDAO authDAO;

    @Override
    public int signup(UserJoinDto userJoinDto) throws Exception{
        return authDAO.signup(userJoinDto);
    }

    @Override
    public UserJoinDto login(HashMap<String, String> hashMap) throws Exception {
        return authDAO.login(hashMap);
    }

    @Override
    public UserJoinDto checkEmail(String email) throws Exception {
        return authDAO.checkEmail(email);
    }

    @Override
    public int deleteUser(String email) throws Exception {
        return authDAO.deleteUser(email);
    }
}
