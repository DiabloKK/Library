package com.example.library.controller.user;

import com.example.library.model.BO.UserBO;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            response.sendRedirect("Dashboard");
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        System.out.println(remember);

        UserBO userBO = new UserBO();
        if(userBO.checkAccount(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username",username);

            if(remember != null) {
                session.setAttribute("username_remember", username);
                session.setAttribute("password_remember", password);
            } else {
                session.setAttribute("username_remember", "");
                session.setAttribute("password_remember", "");
            }

            response.sendRedirect("Dashboard");
        } else {
            request.setAttribute("message", "Invalid username or password!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        }

    }
}
