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

@WebServlet(name = "EditBookServlet", value = "/EditBook")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryBO categoryBO = new CategoryBO();
    private BookBO bookBO = new BookBO();

    public EditBookServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String username = (String) request.getSession().getAttribute("username");

        if(username != null) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            Book book = bookBO.getBookById(id);
            List<Category> list = categoryBO.getCategories();

            request.setAttribute("book", book);
            request.setAttribute("categoryList", list);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-edit-book.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Login");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer category_id = Integer.valueOf(request.getParameter("category"));
        Integer count = Integer.valueOf(request.getParameter("count"));
        String author = request.getParameter("author");
        String file = request.getParameter("image");
        String fileName = "";
//        if (!file.equals("")) {
            String savePath = getServletContext().getRealPath("/") + "assets/img/products";
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            for (Part part : request.getParts()) {
                fileName = getFileName(part);
                part.write(savePath + File.separator + fileName);
            }

        Category category = categoryBO.getCategoryById(category_id);

        Book book = new Book(id, name, count, fileName, author, category_id);

        bookBO.update(book);

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
