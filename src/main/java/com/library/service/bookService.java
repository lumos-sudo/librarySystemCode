package com.library.service;

import com.library.mapper.bookMapper;
import com.library.mapper.borrowBookMapper;
import com.library.pojo.Book;
import com.library.pojo.borrowBook;
import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class bookService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询书籍
     * @return
     */
    public List<Book> selectAllBook(){
        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        bookMapper mapper = sqlSession.getMapper(bookMapper.class);

        //4.调用方法
        List<Book> books=mapper.selectBook();
        sqlSession.close();

        return books;
    };
    public String detail(int bno){
        //接收参数

        //调用BrandMapper.selectAll()

        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        String book = mapper.showDetail(bno);
        System.out.println(book);
        sqlSession.close();

        //4.调用方法
         return book;
    };
    public void lend(int bno){
        SqlSession sqlSession=factory.openSession();

        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        mapper.lend(bno);

        sqlSession.commit();
        sqlSession.close();

    }
    public void returnBook(int bno){
        SqlSession sqlSession=factory.openSession();

        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        mapper.lend(bno);

        sqlSession.commit();
        sqlSession.close();

    }
}
