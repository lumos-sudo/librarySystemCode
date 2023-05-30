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

@WebServlet(name = "UpdateBookServlet", value = "/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    private borrowService service=new borrowService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String bno=request.getParameter("bno");
        int n=Integer.parseInt(bno);

        ///List<borrowBook> books= service.();
      //  request.setAttribute("books",books);
        request.getRequestDispatcher("/returnBookServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
