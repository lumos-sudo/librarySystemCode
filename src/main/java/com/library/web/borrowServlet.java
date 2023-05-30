package com.library.web;

import com.alibaba.fastjson.JSON;
import com.library.pojo.Book;
import com.library.pojo.borrowBook;
import com.library.service.bookService;
import com.library.service.borrowService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/borrowServlet")
public class borrowServlet extends HttpServlet {
    private borrowService service=new borrowService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用Service查询

        List<borrowBook> record= service.selectAllRecord();

        //2、将borrowRecord转换为JSON数据 序列化
        String jsonString= JSON.toJSONString(record);
        System.out.println(jsonString);
        //3、响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
