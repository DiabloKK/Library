package com.example.library.controller.Categories;

import com.example.library.model.BO.CategoryBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoriesServlet", value = "/DeleteCategories")
public class DeleteCategoriesServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    public DeleteCategoriesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            categoryBO.delete(id);

            response.sendRedirect(request.getContextPath() + "/ManageCategories");
        } else {
            response.sendRedirect("Login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
