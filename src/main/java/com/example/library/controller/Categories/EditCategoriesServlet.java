package com.example.library.controller.Categories;

import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditCategoriesServlet", value = "/EditCategories")
public class EditCategoriesServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    public EditCategoriesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("User") != null) {
            String errorString = "Bạn cần đăng nhập trước";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        } else {
            String id = (String) request.getParameter("id");

            Category category = null;

            String errorString = null;

            try {
                category = categoryBO.findCategory(id);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (errorString != null && category == null) {
                response.sendRedirect(request.getServletPath() + "/ManageCategories");
                return;
            }

            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("errorString", errorString);
            request.setAttribute("category", category);

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-edit-categories.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = (String) request.getParameter("name_category");
        Category category = new Category(id, name);
        String errorString = null;
        int result = 0;
        try {
            result = categoryBO.updateCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (result == 0 && errorString == null) {
            errorString = "Chỉnh sửa thất bại";
        }

        if (result == 1)
            errorString = "Chỉnh sửa thành công";
        request.setAttribute("errorString", errorString);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ManageCategories");
        dispatcher.forward(request, response);
    }
}
