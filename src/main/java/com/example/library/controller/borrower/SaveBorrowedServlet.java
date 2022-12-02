package com.example.library.controller.borrower;


import com.example.library.model.BO.BorrowerBO;
import com.example.library.model.BO.UserBO;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveBorrowedServlet", value = "/SaveBorrowed")
public class SaveBorrowedServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameBorrowed = request.getParameter("nameBorrowed");
        Integer idBook = Integer.valueOf(request.getParameter("idBook"));
        String duration = request.getParameter("duration");
        String MSSV = request.getParameter("MSSV");

        BorrowerBO borrowerBO = new BorrowerBO();
        borrowerBO.save(nameBorrowed, idBook, duration, MSSV);

        System.out.println(nameBorrowed);
        System.out.println(idBook);
        System.out.println(duration);
        System.out.println(MSSV);


        response.sendRedirect(request.getContextPath() + "/ListBorrowed");

    }
}
