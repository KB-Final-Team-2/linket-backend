package com.spacebetween.linket.dao.auth;

import com.spacebetween.linket.dto.UserJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

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
    public UserJoinDto login(HashMap<String, String> hashMap) throws Exception {
        return sqlSession.selectOne(NS+"login", hashMap);
    }

    @Override
    public UserJoinDto checkEmail(String email) throws Exception {
        return sqlSession.selectOne(NS+"checkEmail", email);
    }

    @Override
    public int deleteUser(String email) throws Exception {
        return sqlSession.delete(NS+"deleteUser", email);
    }
}
