package com.example.library.controller;

import com.example.library.model.BO.BookBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", value = "/Dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookBO bookBO = new BookBO();
        CategoryBO categoryBO = new CategoryBO();

        request.setAttribute("total_books", bookBO.getTotalBooks());
        request.setAttribute("books", bookBO.getBooks());
        request.setAttribute("total_categories", categoryBO.getTotalCategories());
        request.setAttribute("categories", categoryBO.getCategories());

        for(Book book : bookBO.getBooks()) {
            System.out.println(book);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
