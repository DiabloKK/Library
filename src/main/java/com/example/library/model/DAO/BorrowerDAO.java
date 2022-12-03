package com.example.library.model.DAO;

import com.example.library.model.entity.Borrower;
import com.example.library.model.entity.TopBook;
import com.example.library.model.entity.TopCategory;
import com.example.library.model.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class BorrowerDAO {
    private Connection conn;
    private PreparedStatement insert = null;
    private PreparedStatement update = null;

    public BorrowerDAO() {
        try {
            conn = ConnectDatabase.getMySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Borrower> getBorrowers() {
        List<Borrower> borrowers = new ArrayList<>();

        String sql = "select * from borrower";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String mssv = resultSet.getString("mssv");
                Integer book_id = resultSet.getInt("book_id");
                Date borrower_date = resultSet.getDate("borrower_date");
                Date deadline_date = resultSet.getDate("deadline_date");
                Date return_date = resultSet.getDate("return_date");
                boolean status = resultSet.getBoolean("status");
                borrowers.add(new Borrower(id, name, mssv, book_id, borrower_date, deadline_date, return_date, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  borrowers;
    }

    public void save(Borrower borrower) {
        String query = "insert into borrower(name, mssv, book_id, borrower_date, deadline_date, return_date, status) values (?,?,?,?,?,?,?)";
        try {
            insert = conn.prepareStatement(query);
            insert.setString(1, borrower.getName());
            insert.setString(2, borrower.getMssv());
            insert.setInt(3, borrower.getId());
            insert.setDate(4, borrower.getBorrower_date());
            insert.setDate(5, borrower.getDeadline_date());
            insert.setDate(6, borrower.getReturn_date());
            insert.setBoolean(7, borrower.isStatus());
            insert.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Borrower borrower) {
        String query = "update borrower set return_date = ?, status = ? where id = ?";
        try {
            update = conn.prepareStatement(query);
            update.setDate(1, borrower.getReturn_date());
            update.setBoolean(2, borrower.isStatus());
            update.setInt(3, borrower.getId());
            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String query = "delete from borrower where id = " + id;
        try {
            conn.createStatement().executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedHashMap<Integer, Integer> getTopBookBorrowed() {
        LinkedHashMap<Integer, Integer> top = new LinkedHashMap<>();
        String query = "select count(book_id) as times, book_id from borrower group by book_id order by times desc limit 5;";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("book_id");
                Integer times = resultSet.getInt("times");
                top.put(id, times);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return top;
    }

    public List<TopCategory> getTopCategoryBorrowed() {

        List<TopCategory> topCategories = new ArrayList<>();

        String query = "select category.name, count(category.name) as quantity from borrower left join book\n" +
                "on borrower.book_id = book.id\n" +
                "inner join category \n" +
                "on book.category_id = category.id\n" +
                "group by category.name limit 5";

        try {
            ResultSet resultSet = conn.createStatement().executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer times = resultSet.getInt("quantity");
                topCategories.add(new TopCategory(name, times));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topCategories;

    }

}
