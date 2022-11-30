package com.example.library.controller;

import com.example.library.model.BO.UserBO;
import com.example.library.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "USER";

        UserBO userBO = new UserBO();

        if(userBO.getUserByUsername(username) != null) {

            request.setAttribute("message", "This username is available!");

            RequestDispatcher  dispatcher = request.getRequestDispatcher("/pages-register.jsp");
            dispatcher.forward(request, response);
        } else {

            User user = new User(0,username, password, firstName, lastName, phone, role);
            userBO.save(user);

            RequestDispatcher  dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

    }
}
