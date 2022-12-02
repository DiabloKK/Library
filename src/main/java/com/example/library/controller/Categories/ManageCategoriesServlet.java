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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ManageCategoriesServlet", value = "/ManageCategories")
public class ManageCategoriesServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    public ManageCategoriesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            List<Category> list = categoryBO.getCategories();

            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("categoryList", list);
            request.getSession().setAttribute("Check", "ManageCategory");
            // Forward sang /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-manage-categories.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
