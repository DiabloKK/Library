package com.example.library.controller.borrower;
import com.example.library.model.BO.BookBO;
import com.example.library.model.BO.BorrowerBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Borrower;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreateBorrowedServlet", value = "/CreateBorrowed")
public class CreateBorrowedServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            BookBO bookBO = new BookBO();
            request.setAttribute("Books", bookBO.getBooks());

            RequestDispatcher dispatcher = request.getRequestDispatcher("/create-borrower.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
