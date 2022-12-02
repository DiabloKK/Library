package com.example.library.controller.Categories;

import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            Integer id = Integer.valueOf(request.getParameter("id"));

            Category category = categoryBO.getCategoryById(id);

            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("category", category);

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-edit-categories.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name_category");
        Category category = new Category(id, name);

        categoryBO.update(category);

        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ManageCategories");
        dispatcher.forward(request, response);
    }
}
