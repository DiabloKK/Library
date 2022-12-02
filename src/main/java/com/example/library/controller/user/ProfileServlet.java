package com.example.library.controller.user;

import com.example.library.model.BO.UserBO;
import com.example.library.model.entity.User;
import com.mysql.cj.util.DnsSrv;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/Profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            UserBO userBO = new UserBO();

            User user = userBO.getUserByUsername(username);
            request.setAttribute("user", user);

            String message = (String) request.getSession().getAttribute("message");
            if(message != null) {
                request.setAttribute("message", message);
                request.getSession().removeAttribute("message");

                request.setAttribute("nameBtn", request.getSession().getAttribute("nameBtn"));
                request.getSession().removeAttribute("nameBtn");
                request.setAttribute("nameDiv", request.getSession().getAttribute("nameDiv"));
                request.getSession().removeAttribute("nameDiv");

            } else {
                request.setAttribute("nameBtn", "overviewBtn");
                request.setAttribute("nameDiv", "profile-overview");
            }

            if(user.getRole().equals("MANAGE")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/users-profile.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/users-profile-user.jsp");
                dispatcher.forward(request, response);
            }

        } else {
            response.sendRedirect("Login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
