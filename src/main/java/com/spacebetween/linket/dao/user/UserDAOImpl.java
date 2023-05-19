package com.spacebetween.linket.dao.user;

import com.spacebetween.linket.dto.UserJoinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class UserDAOImpl implements UserDAO{
    public static final String NS = "com.spacebetween.linket.mapper.UserMapper.";
    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserJoinDto getUser(String email) throws Exception {
        return sqlSession.selectOne(NS+"getUser", email);
    }

    @Override
    public UserJoinDto checkUserPwd(HashMap<String, String> hashMap) throws Exception {
        return sqlSession.selectOne(NS+"checkUserPwd", hashMap);
    }

    @Override
    public int updateUser(HashMap<String, String> hashMap) throws Exception {
        return sqlSession.update(NS+"updateUser",hashMap);
    }
}
