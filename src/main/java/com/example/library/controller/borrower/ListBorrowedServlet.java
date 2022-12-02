package com.example.library.controller;

import com.example.library.model.BO.BookBO;
import com.example.library.model.BO.BorrowerBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Borrower;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ListBorrowedServlet", value = "/ListBorrowed")
public class ListBorrowedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BorrowerBO borrowerBO = new BorrowerBO();


        request.setAttribute("borrowers", borrowerBO.getBorrowers());

        System.out.println("2222");
        for(Borrower borrower : borrowerBO.getBorrowers()) {
            System.out.println(borrower);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Listborrowed.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
