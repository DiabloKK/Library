package com.example.library.controller.Categories;

import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageCategoriesServlet", value = "/ManageCategories")
public class ManageCategoriesServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();

    public ManageCategoriesServlet() {
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
            String errorString = null;
            ArrayList<Category> list = null;

            try {
                list = categoryBO.listCategory();
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }
            // Lưu thông tin vào request attribute trước khi forward sang views.
            request.setAttribute("errorString", errorString);
            request.setAttribute("categoryList", list);
            request.getSession().setAttribute("Check", "ManageCategory");
            // Forward sang /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-manage-categories.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
