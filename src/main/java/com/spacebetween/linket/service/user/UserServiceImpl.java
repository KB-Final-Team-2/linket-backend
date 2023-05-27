package com.spacebetween.linket.service.user;

import com.spacebetween.linket.dao.user.UserDAO;
import com.spacebetween.linket.dto.UserJoinDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public Map<String,Object> getUser(String email) throws Exception {
        return userDAO.getUser(email);
    }

    @Override
    public Map<String,Object> checkUserPwd(HashMap<String, String> hashMap) throws Exception {
        return userDAO.checkUserPwd(hashMap);
    }

    @Override
    public int updateUserPhone(HashMap<String, String> hashMap) throws Exception {
        return userDAO.updateUserPhone(hashMap);
    }

    @Override
    public int updateUserPassword(HashMap<String, String> hashMap) throws Exception {
        return userDAO.updateUserPassword(hashMap);
    }


}
