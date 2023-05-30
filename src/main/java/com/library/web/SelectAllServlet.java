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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private bookService service=new bookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、调用Service查询


       List<Book> books= service.selectAllBook();

        request.setAttribute("books",books);

        request.getRequestDispatcher("/user_book.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
