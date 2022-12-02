package com.example.library.controller;

import com.example.library.model.BO.BookBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.BO.UserBO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", value = "/Dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            BookBO bookBO = new BookBO();
            CategoryBO categoryBO = new CategoryBO();
            UserBO userBO = new UserBO();

            User user = userBO.getUserByUsername(username);

            request.setAttribute("total_books", bookBO.getTotalBooks());
            request.setAttribute("books", bookBO.getBooks());
            request.setAttribute("total_categories", categoryBO.getTotalCategories());
            request.setAttribute("categories", categoryBO.getCategories());
            request.setAttribute("user", user);

            if(user.getRole().equals("MANAGE")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard-user.jsp");
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
