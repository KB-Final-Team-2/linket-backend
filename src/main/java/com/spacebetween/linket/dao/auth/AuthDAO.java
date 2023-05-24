package com.spacebetween.linket.dao.auth;

import com.spacebetween.linket.dto.UserJoinDto;

import java.util.HashMap;

public interface AuthDAO {
    int signup(UserJoinDto userJoinDto) throws Exception;
    UserJoinDto login(HashMap<String, String> hashMap) throws Exception;
    UserJoinDto checkEmail(String email) throws Exception;
    int updateUser(String email) throws Exception;
}
