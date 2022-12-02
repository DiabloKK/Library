package com.example.library.controller.book;

import com.example.library.model.BO.BookBO;
import com.example.library.model.entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageBookServlet", value = "/ManageBook")
public class ManageBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        BookBO bookBO = new BookBO();
        if(username != null) {
            List<Book> list = bookBO.getBooks();
            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("bookList", list);
            request.getSession().setAttribute("Check", "ManageBook");
            // Forward sang /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-manage-book.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
