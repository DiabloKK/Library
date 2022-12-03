package com.example.library.controller.book;

import com.example.library.model.BO.BookBO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteBookServlet", value = "/DeleteBook")
public class DeleteBookServlet extends HttpServlet {
    private BookBO bookBO = new BookBO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");

        if (username != null) {
            Integer id = Integer.valueOf(request.getParameter("id"));

            if (id == null) {
                bookBO.deleteAllBook();
            } else {
                bookBO.delete(id);
            }
            request.setAttribute("errorString", "Đã xóa thành công");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ManageBook");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
