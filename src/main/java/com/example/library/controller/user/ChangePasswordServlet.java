package com.example.library.controller.user;

import com.example.library.model.BO.UserBO;
import com.example.library.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangePasswordServlet", value = "/Profile/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currentPassword = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
        String renewpassword = request.getParameter("renewpassword");
        String username = request.getParameter("username");

        UserBO userBO = new UserBO();
        User user = userBO.getUserByUsername(username);
        if(!user.getPassword().equals(currentPassword)) {
            request.getSession().setAttribute("message", "Current Password Invalid!");
        } else {
            if (!newpassword.equals(renewpassword)) {
                request.getSession().setAttribute("message", "Passwords must be same!");
            } else {
                userBO.update(newpassword, username);
            }
        }
        request.getSession().setAttribute("nameBtn", "changeBtn");
        request.getSession().setAttribute("nameDiv", "profile-change-password");
        response.sendRedirect("/Library/Profile");
    }
}
