package com.example.library.model.DAO;

import com.example.library.model.BO.BorrowerBO;
import com.example.library.model.BO.CategoryBO;
import com.example.library.model.entity.Book;
import com.example.library.model.entity.Category;
import com.example.library.model.entity.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDAO {

    private Connection conn;
    private PreparedStatement insert = null;
    private PreparedStatement update = null;

    CategoryBO categoryBO = new CategoryBO();

    BorrowerBO borrowerBO = new BorrowerBO();

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
        return books;
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
            update.setInt(6, book.getId());
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

    public Book findBook(String id) throws SQLException, ClassNotFoundException {
        String sql = "Select * from book where id=?";

        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String category_id = rs.getString("category_id");
            Category category = new Category();
            try {
                category = categoryBO.findCategory(category_id);
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            String amount = rs.getString("amount");
            String image = rs.getString("image");
            String author = rs.getString("author");

            Book book = new Book();
            book.setId(Integer.parseInt(id));
            book.setName(name);
            book.setCategory(category);
            book.setAmount(Integer.parseInt(amount));
            book.setAuthor(author);
            book.setImage(image);
            return book;
        }
        return null;
    }

    public int updateBook(Book book) throws SQLException {
        int result = 0;
        String sql = "update book set name =?,category_id =?,amount =?,image =?, author =?  where id=? ";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);

        pstm.setString(1, book.getName());
        pstm.setInt(2, book.getCategory_id());
        pstm.setInt(3, book.getAmount());
        pstm.setString(4, book.getImage());
        pstm.setString(5, book.getAuthor());
        pstm.setInt(6, book.getId());

        result = pstm.executeUpdate();
        return result;
    }

    public int insertBook(Book book) throws SQLException, ClassNotFoundException {
        int result = 0;
        String sql = "INSERT INTO Book (name, amount, image, author, category_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);

        pstm.setString(1, book.getName());
        pstm.setInt(2, book.getAmount());
        pstm.setString(3, book.getImage());
        pstm.setString(4, book.getAuthor());
        pstm.setInt(5, book.getCategory_id());

        result = pstm.executeUpdate();
        System.out.println("Ketqua" + result);
        return result;
    }

    public int deleteBook(String id) throws ClassNotFoundException, SQLException {
        int result = 0;
        borrowerBO.delete(Integer.parseInt(id));
        String sql = "Delete From Book where id= ?";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        pstm.setString(1, id);
        result = pstm.executeUpdate();
        return result;
    }

    public int deleteAllBook() throws ClassNotFoundException, SQLException {
        int result = 0;
        String query = "Delete * From Book";
        try {
            borrowerBO.deleteAllReader();
            update = conn.prepareStatement(query);
            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
