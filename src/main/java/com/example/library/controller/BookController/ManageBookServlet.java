package com.example.library.controller.BookController;

import com.example.library.model.BO.BookBO;
import com.example.library.model.entity.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ManageBookServlet", value = "/ManageBook")
public class ManageBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookBO bookBO = new BookBO();
        if (request.getSession().getAttribute("User") != null) {
            String errorString = "Bạn cần đăng nhập trước";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        } else {
            String errorString = null;
            List<Book> list = null;
            try {
                list = bookBO.getBooks();
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }
            // Lưu thông tin vào request attribute trước khi forward sang views.
            System.out.println(list);
            request.setAttribute("errorString", errorString);
            request.setAttribute("bookList", list);
            request.getSession().setAttribute("Check", "ManageBook");
            // Forward sang /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-manage-book.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
