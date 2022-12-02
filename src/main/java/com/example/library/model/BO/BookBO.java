package com.example.library.model.BO;

import com.example.library.model.DAO.BookDAO;
import com.example.library.model.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookBO {

    private BookDAO bookDAO;
    private CategoryBO categoryBO;

    public BookBO() {
        bookDAO = new BookDAO();
        categoryBO = new CategoryBO();
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books = bookDAO.getBooks();
        for (Book book : books) {
            book.setCategory_name(categoryBO.getNameById(book.getCategory_id()));
        }
        return books;
    }
    public String getNameById(Integer id){
        for (Book book: getBooks()) {
            if(book.getId() == id) return  book.getName();
        }
        return null;
    }


    public void save(Book book) {
        bookDAO.save(book);
    }

    public void update(Book book) {
        bookDAO.update(book);
    }

    public void delete(Integer id) {
        bookDAO.delete(id);
    }


    public int getTotalBooks() {
        int sum = 0;
        for (Book book : getBooks()) {
            sum += book.getAmount();
        }
        return sum;
    }

}
