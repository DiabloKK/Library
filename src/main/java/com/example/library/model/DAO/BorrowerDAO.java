package com.example.library.model.DAO;

import com.example.library.model.entity.Borrower;
import com.example.library.model.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
            insert.setInt(3, borrower.getBook_id());
            insert.setDate(4, borrower.getBorrower_date());
            insert.setDate(5, borrower.getDeadline_date());
            insert.setDate(6, borrower.getReturn_date());
            insert.setBoolean(7, borrower.isStatus());
            System.out.println(insert);
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
            System.out.println(update);
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

}
