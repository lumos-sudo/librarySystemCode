package com.library.mapper;
import com.library.pojo.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

public interface borrowBookMapper {
    /**
     * 查询所有借书记录
     * @return
     */
@Select("SELECT book.bno 编号,bname 书名,bdate 借阅日期,\n" +
        "30-datediff(curdate(),bdate) 剩余天数\n" +
        "FROM book,borrow\n" +
        "WHERE book.bno=borrow.bno AND borrow.uno=34134432 AND breturn=\"否\";\n")
    List<borrowBook> selectAllRecord();
}

