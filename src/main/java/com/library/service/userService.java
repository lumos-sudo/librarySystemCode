package com.library.service;

import com.library.mapper.UserMapper;
import com.library.mapper.bookMapper;
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
    public User selectEmail(String username,String email){
        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectEmail(username, email);
        sqlSession.close();
        return user;
    }
    public User add(String username,String password,String sex,String email){

        SqlSession sqlSession=factory.openSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        userMapper.add(username,password,sex,email);
        User select = userMapper.select(username);
        sqlSession.commit();
        sqlSession.close();
        return select;
    }

    public void udatePsw( String username,String psw){
        SqlSession sqlSession=factory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updatePsw(username,psw);

        sqlSession.commit();
        sqlSession.close();

    }
}
