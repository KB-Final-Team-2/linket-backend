package com.spacebetween.linket.service.auth;

import com.spacebetween.linket.dto.UserJoinDto;

import java.util.HashMap;
import java.util.Map;

public interface AuthService {
    int signup(UserJoinDto userJoinDto) throws Exception;
    Map<String,Object> login(HashMap<String, String> hashMap) throws Exception;
    UserJoinDto checkEmail(String email) throws Exception;
    int updateUser(String email) throws Exception;
}
