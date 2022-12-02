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
        if (request.getSession().getAttribute("User") != null) {
            String errorString = "Bạn cần đăng nhập trước";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-login.jsp");
            dispatcher.forward(request, response);
        } else {
            String id = request.getParameter("id");
            String errorString = null;
            Book book = new Book();
            ArrayList<Category> list = null;

            try {
                book = bookBO.findBook(id);
                list = categoryBO.listCategory();
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("************" + book);
            if (request.getAttribute("errorString") != null) {
                errorString = (String) request.getAttribute("errorString");
            }
            request.setAttribute("book", book);
            request.setAttribute("categoryList", list);
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/pages-edit-book.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String category_id = request.getParameter("category");
        String count = request.getParameter("count");
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
//        }
//		String filePath = savePath + File.separator + fileName;

        Category category = new Category();
        try {
            category = categoryBO.findCategory(category_id);
        } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Book book = new Book();
        book.setId(Integer.parseInt(id));
        book.setName(name);
        book.setCategory_id(category.getId());
        book.setAmount(Integer.parseInt(count));
        book.setAuthor(author);
        book.setImage(fileName);
        int result = 0;
        String errorString = null;
        try {
            result = bookBO.update(book);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (result == 0 && errorString == null) {
            errorString = "Chỉnh sửa thất bại";
        }
        if (result == 1)
            errorString = "Chỉnh sửa thành công";
        request.setAttribute("errorString", errorString);

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
