package com.spacebetween.linket.dao.auth;

import com.spacebetween.linket.dto.UserJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthDAOImpl implements AuthDAO{
    public static final String NS = "com.spacebetween.linket.mapper.AuthMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int signup(UserJoinDto userJoinDto) throws Exception{
        return sqlSession.insert(NS+"signup", userJoinDto);
    }

    @Override
    public Map<String,Object> login(HashMap<String, String> hashMap) throws Exception {
        return sqlSession.selectOne(NS+"login", hashMap);
    }

    @Override
    public UserJoinDto checkEmail(String email) throws Exception {
        return sqlSession.selectOne(NS+"checkEmail", email);
    }

    @Override
    public int updateUser(String email) throws Exception {
        return sqlSession.update(NS+"updateUser", email);
    }
}
