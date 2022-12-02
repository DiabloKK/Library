package com.example.library.controller.user;

import com.example.library.model.BO.UserBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersServlet", value = "/Users")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        if(username != null) {

            UserBO userBO = new UserBO();
            request.setAttribute("users", userBO.getUsers());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/users-view.jsp");
            dispatcher.forward(request, response);

        } else {
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
