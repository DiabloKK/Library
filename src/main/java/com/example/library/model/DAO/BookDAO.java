package com.example.library.model.DAO;

import com.example.library.model.entity.Book;
import com.example.library.model.entity.Category;
import com.example.library.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private Connection conn;
    private PreparedStatement insert = null;
    private PreparedStatement update = null;

    public BookDAO() {
        try {
            conn = ConnectDatabase.getMySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();

        String sql = "select * from book";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer amount = resultSet.getInt("amount");
                String image = resultSet.getString("image");
                String author = resultSet.getString("author");
                Integer category_id = resultSet.getInt("category_id");
                books.add(new Book(id, name, amount, image, author, category_id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  books;
    }

    public void save(Book book) {
        String query = "insert into book(name, amount, image, author, category_id) values (?,?,?,?,?)";
        try {
            insert = conn.prepareStatement(query);
            insert.setString(1, book.getName());
            insert.setInt(2, book.getAmount());
            insert.setString(3, book.getImage());
            insert.setString(4, book.getAuthor());
            insert.setInt(5, book.getCategory_id());
            insert.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        String query = "update book name = ?, amount = ?, image = ?, author = ?, category_id = ? where id = ?";
        try {
            update = conn.prepareStatement(query);
            update.setString(1, book.getName());
            update.setInt(2, book.getAmount());
            update.setString(3, book.getImage());
            update.setString(4, book.getAuthor());
            update.setInt(5, book.getCategory_id());
            update.setInt(6 , book.getId());
            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String query = "delete from book where id = " + id;
        try {
            conn.createStatement().executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
