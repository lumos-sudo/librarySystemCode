package com.library.mapper;

import com.library.pojo.Book;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface bookMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("SELECT bno,bname,wri,ssort,pub,inq\n" +
            "FROM book,sort\n" +
            "WHERE book.sno=sort.sno; \n")
    List<Book> selectBook();


    /**
     * 查看简介
     * @param bno
     * @return
     */

    @Select("SELECT intro\n" +
            "FROM book\n" +
            "WHERE bno=#{bno};\n")
    String showDetail(int bno);

    /**
     * 借阅
     */
    @Update("UPDATE book\n" +
            "SET inq=inq-1\n" +
            "WHERE bno=#{bno};\n")
    void lend(int bno);

    /**
     * 还书
     */
    @Update("UPDATE book\n" +
            "SET inq=inq+1\n" +
            "WHERE bno=#{bno};\n")
    void returnBook(int bno);
}
