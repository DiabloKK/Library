package com.example.library.model.BO;

import com.example.library.model.DAO.BookDAO;
import com.example.library.model.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookBO {

    private BookDAO bookDAO;
    private CategoryBO categoryBO;

    public BookBO() {
        bookDAO = new BookDAO();
        categoryBO = new CategoryBO();
    }

    public List<Book> getBooks() throws SQLException, ClassNotFoundException {
        List<Book> books = new ArrayList<>();
        books = bookDAO.getBooks();
        for (Book book : books) {
            book.setCategory_name(categoryBO.getNameById(book.getCategory_id()));
        }
        return books;
    }

    public void save(Book book) {
        bookDAO.save(book);
    }

    public int update(Book Book) throws ClassNotFoundException, SQLException {
        return bookDAO.updateBook(Book);
    }

    public void delete(Integer id) {
        bookDAO.delete(id);
    }

    public int getTotalBooks() throws SQLException, ClassNotFoundException {
        int sum = 0;
        for (Book book : getBooks()) {
            sum += book.getAmount();
        }
        return sum;
    }

    public Book findBook(String id) throws ClassNotFoundException, SQLException {
        return bookDAO.findBook(id);
    }

    public int insertBook(Book book) throws SQLException, ClassNotFoundException {
        int result = 0;
        result = bookDAO.insertBook(book);
        return result;
    }

    public boolean deleteBook(String id) throws ClassNotFoundException, SQLException {
        int result = bookDAO.deleteBook(id);
        return result != 0;
    }

    public boolean deleteAllBook() throws ClassNotFoundException, SQLException {
        int result = bookDAO.deleteAllBook();
        return result != 0;
    }
}
