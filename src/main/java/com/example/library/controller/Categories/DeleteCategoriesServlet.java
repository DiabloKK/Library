package com.example.library.controller.Categories;

import com.example.library.model.BO.CategoryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteCategoriesServlet", value = "/DeleteCategories")
public class DeleteCategoriesServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    public DeleteCategoriesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        boolean result;
        categoryBO.delete(Integer.parseInt(id));
//        try {
//            result = categoryBO.delete(Integer.parseInt(id));
//            System.out.println("Ket qua"+result);
//            if (result == true) {
//                request.setAttribute("errorString", "Đã xóa thành công");
//            } else {
//                request.setAttribute("errorString", "Lỗi cơ sở dữ liệu");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }

        response.sendRedirect(request.getContextPath() + "/ManageCategories");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
