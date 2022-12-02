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

@WebServlet(name = "AddCategoriesServlet", value = "/AddCategories")
public class AddCategoriesServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-add-categories.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name_category = request.getParameter("name_category");
        Category category = new Category(0, name_category);

        categoryBO.save(category);

        response.sendRedirect(request.getContextPath() + "/ManageCategories");
    }
}
