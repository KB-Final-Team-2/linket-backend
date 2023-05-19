package com.spacebetween.linket.dao.user;

import com.spacebetween.linket.dto.UserJoinDto;

import java.util.HashMap;

public interface UserDAO {
    UserJoinDto getUser(String email) throws Exception;
    UserJoinDto checkUserPwd(HashMap<String,String> hashMap) throws Exception;
    int updateUser(HashMap<String,String> hashMap) throws Exception;
}
