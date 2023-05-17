package com.spacebetween.linket.service.auth;

import com.spacebetween.linket.dto.UserJoinDto;

import java.util.HashMap;

public interface AuthService {
    int signup(UserJoinDto userJoinDto) throws Exception;
    UserJoinDto login(HashMap<String, String> hashMap) throws Exception;
    UserJoinDto checkEmail(String email) throws Exception;
}
