package com.aominfosystem.controller;


import com.aominfosystem.utils.MyBatisUtil;
import com.aominfosystem.mapper.UserMapper;
import com.aominfosystem.pojo.User;
import org.apache.ibatis.session.SqlSession;

public class UserController {

    public UserController(){}
    public long findUserGrade(long fromqq){
        long userGrade;
        User user = findUser(fromqq);
        if (user == null){
            userGrade = 0;
        }else {
            userGrade = user.getGrade();
        }
        return userGrade;

    }

    public User findUser(long fromqq){
        SqlSession sqlSession = MyBatisUtil.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findByFromqq(fromqq);
        MyBatisUtil.closeSession();
        return user;
    }
}
