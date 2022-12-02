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

@WebServlet(name = "UpdateBorrowedServlet", value = "/UpdateBorrowed")
public class UpdateBorrowedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            BorrowerBO borrowerBO = new BorrowerBO();
            Integer id = Integer.valueOf(request.getParameter("id"));
            borrowerBO.updateStatusAndReturnDate(id);

            response.sendRedirect(request.getContextPath() + "/ListBorrowed");

        } else {
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
