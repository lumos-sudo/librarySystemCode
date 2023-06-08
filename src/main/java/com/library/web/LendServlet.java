package com.library.web;

import com.library.pojo.Book;
import com.library.pojo.User;
import com.library.service.bookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/lendServlet")
public class LendServlet extends HttpServlet {
    private bookService service=new bookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bno=request.getParameter("bno");
        int n=Integer.parseInt(bno);
        //获取用户id
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
        int uno=user.getUno();
        if(service.judge(n,uno)==true){
            service.lend(n,uno);
        }
        List<Book> books= service.selectAllBook();
        request.setAttribute("books",books);
        request.getRequestDispatcher("/user_book.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
