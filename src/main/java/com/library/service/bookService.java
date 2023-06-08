package com.library.service;

import com.library.mapper.bookMapper;
import com.library.pojo.Book;

import com.library.pojo.borrowRecord;
import com.library.pojo.returnRecord;
import com.library.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public boolean judge(int bno,int uno){
        SqlSession sqlSession=factory.openSession();
        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
       //获取系统当前时间
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String bdate=date.format(formatter);
       //
        borrowRecordService service= new borrowRecordService();
        List< borrowRecord> record=service.selectAllRecord(uno);
        for ( borrowRecord o : record) {
            if(mapper.selectInq(bno)<=0||(o.getBdate().equals(bdate)&&o.getBno().equals(bno))){
              return false;
            }
        }
        return true;
    }
    public void lend(int bno,int uno){
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String bdate=date.format(formatter);
        SqlSession sqlSession=factory.openSession();
        bookMapper mapper = sqlSession.getMapper(bookMapper.class);
        mapper.lend(bno);
        mapper.insertData(bno,uno,bdate);
        sqlSession.commit();
        sqlSession.close();

    }



    public List<Book> query(String param){
        //调用BrandMapper.selectAll()
        int bno=Integer.parseInt(param);
        //2.获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //3.获取borrowMapper
        bookMapper mapper = sqlSession.getMapper(bookMapper.class);

        //4.调用方法
        List<Book> books=mapper.query(bno);
        sqlSession.close();

        return books;
    };
}
