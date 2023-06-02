package com.library.service;

import com.library.mapper.UserMapper;
import com.library.pojo.User;
import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class userService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username,String password){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

       User user = userMapper.selectUser(username, password);
        sqlSession.close();
        return user;
    }
}
