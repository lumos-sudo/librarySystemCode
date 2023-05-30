package com.library.service;

import java.util.List;
import com.library.pojo.*;
import com.library.mapper.*;

import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
//访问数据库建立连接
public class borrowService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询借阅书籍记录
     * @return
     */
    public List<borrowBook> selectAllRecord(){
        //调用BrandMapper.selectAll()

       //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        borrowBookMapper mapper = sqlSession.getMapper(borrowBookMapper.class);

       //4.调用方法
        List<borrowBook> books=mapper.selectAllRecord();
        sqlSession.close();

        return books;
    };

    /**
     * 还书
     * @param bno
     */
    public void lend(int bno){
        SqlSession sqlSession=factory.openSession();

        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        mapper.lend(bno);

        sqlSession.commit();
        sqlSession.close();

    }
}
