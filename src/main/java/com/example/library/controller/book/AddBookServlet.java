package com.example.library.controller.book;

import com.example.library.model.BO.BookBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddBookServlet", value = "/AddBook")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class AddBookServlet extends HttpServlet {
    private CategoryBO categoryBO = new CategoryBO();
    private BookBO bookBO = new BookBO();

    public AddBookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");

        if (username != null) {
            String errorString = "";
            List<Category> list = null;

            try {
                list = categoryBO.getCategories();
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }
            request.setAttribute("errorString", errorString);
            request.setAttribute("categoryList", list);
            request.getSession().setAttribute("Check", "AddBook");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-add-book.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        Integer category_id = Integer.valueOf(request.getParameter("category"));
        Integer count = Integer.valueOf(request.getParameter("count"));
        String author = request.getParameter("author");
//		String path = getServletContext().getRealPath("/") + "Resources/images/";
        String savePath = getServletContext().getRealPath("/") + "Resources/img/products";
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        String fileName = "";
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(savePath + File.separator + fileName);
        }
        bookBO.save(new Book(0, name, count, fileName, author, category_id));
        request.setAttribute("errorString", "Thêm sách thành công");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ManageBook");
        dispatcher.forward(request, response);
    }
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "product-xyz";
    }
}
