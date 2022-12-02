package com.example.library.controller.BookController;

import com.example.library.model.BO.BookBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
        if (request.getSession().getAttribute("User") != null) {
            String errorString = "Bạn cần đăng nhập trước";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        } else {
            String errorString = "";
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
            request.getSession().setAttribute("Check", "AddBook");
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-add-book.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String category_id = request.getParameter("category");
        String count = request.getParameter("count");
        String author = request.getParameter("author");
//		String path = getServletContext().getRealPath("/") + "Resources/images/";
        String savePath = getServletContext().getRealPath("/") + "assets/img/products";
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        String fileName = "";
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            part.write(savePath + File.separator + fileName);
        }
//        String fileName = "product" + "-" + name + "-" + author;
//        file.write(savePath + File.separator + fileName);

        Book book = new Book();
        Category category = new Category();
        try {
            category = categoryBO.findCategory(category_id);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
        book.setName(name);
        book.setCategory_id(category.getId());
        book.setAmount(Integer.parseInt(count));
        book.setAuthor(author);
        book.setImage(fileName);
        try {
            int result = bookBO.insertBook(book);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("errorString", "Thêm sách thành công");
        doGet(request, response);
    }
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "product-xyz";
    }
}
