package com.example.library.controller;

import com.example.library.model.BO.BookBO;
import com.example.library.model.BO.BorrowerBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.BO.UserBO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.TopCategory;
import com.example.library.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DashboardServlet", value = "/Dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            BookBO bookBO = new BookBO();
            CategoryBO categoryBO = new CategoryBO();
            UserBO userBO = new UserBO();
            BorrowerBO borrowerBO = new BorrowerBO();

            User user = userBO.getUserByUsername(username);
            List<TopCategory> topCategories = borrowerBO.getTopCategoryBorrowed();

            request.setAttribute("total_books", bookBO.getTotalBooks());
            request.setAttribute("books", bookBO.getBooks());
            request.setAttribute("total_categories", categoryBO.getTotalCategories());
            request.setAttribute("categories", categoryBO.getCategories());
            request.setAttribute("user", user);
            request.setAttribute("topBooks", borrowerBO.getTopBookBorrowed());
            request.setAttribute("topCategories", topCategories);


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
