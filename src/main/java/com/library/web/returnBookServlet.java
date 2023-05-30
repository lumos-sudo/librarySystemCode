package com.library.web;

import com.library.pojo.Book;
import com.library.pojo.borrowBook;
import com.library.service.bookService;
import com.library.service.borrowService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/returnBookServlet")
public class returnBookServlet extends HttpServlet {
   private borrowService service=new borrowService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<borrowBook> records = service.selectAllRecord();
        request.setAttribute("records",records);
        request.getRequestDispatcher("/user_return.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
