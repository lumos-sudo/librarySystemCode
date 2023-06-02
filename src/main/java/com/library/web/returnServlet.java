package com.library.web;

import com.alibaba.fastjson.JSON;
import com.library.pojo.borrowBook;
import com.library.service.borrowService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/returnServlet")
public class returnServlet extends HttpServlet {
    private borrowService service=new borrowService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String id=request.getParameter("bno");

        request.setAttribute("bno",id);
        request.getRequestDispatcher("/returnBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
