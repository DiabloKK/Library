package com.example.library.controller;

import com.example.library.model.BO.UserBO;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String)request.getSession().getAttribute("username");
        UserBO userBO = new UserBO();
        if(userBO.getUserByUsername(username) != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Dashboard");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserBO userBO = new UserBO();
        if(userBO.checkAccount(username, password)) {
            request.getSession().setAttribute("username", username);

            RequestDispatcher dispatcher = request.getRequestDispatcher("Dashboard");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Invalid username or password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
