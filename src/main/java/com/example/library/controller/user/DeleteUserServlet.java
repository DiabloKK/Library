package com.example.library.controller.user;

import com.example.library.model.BO.UserBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/Users/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        UserBO userBO = new UserBO();
        userBO.delete(id);

        response.sendRedirect("/Library/Users");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
