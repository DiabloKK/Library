package com.example.library.controller.user;

import com.example.library.model.BO.UserBO;
import com.example.library.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditProfileServlet", value = "/Profile/Edit")
public class EditProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        Integer id = Integer.valueOf(request.getParameter("id"));

        UserBO userBO = new UserBO();

        if(!username.equals(userBO.getUserById(id).getUsername()) && userBO.getUserByUsername(username) != null) {
            request.getSession().setAttribute ("message", "This username is available!");
        } else {
            userBO.update(firstName, lastName, phone, username, id);
        }

        request.getSession().setAttribute("nameBtn", "editBtn");
        request.getSession().setAttribute("nameDiv", "profile-edit");

        response.sendRedirect("/Library/Profile");

    }
}
