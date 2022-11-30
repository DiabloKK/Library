package com.example.library.model.DAO;

import com.example.library.model.entity.Category;
import com.example.library.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection conn;
    private PreparedStatement insert = null;
    private PreparedStatement update = null;

    public UserDAO() {
        try {
            conn = ConnectDatabase.getMySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        String sql = "select * from user";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phone = resultSet.getString("phone");
                String role = resultSet.getString("role");
                users.add(new User(id, username, password, firstName, lastName, phone, role));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  users;
    }

    public void save(User user) {
        String query = "insert into user(username, password, firstName, lastName, phone, role) values (?,?,?,?,?,?)";
        try {
            insert = conn.prepareStatement(query);
            insert.setString(1, user.getUsername());
            insert.setString(2, user.getPassword());
            insert.setString(3, user.getFirstName());
            insert.setString(4, user.getLastName());
            insert.setString(5, user.getPhone());
            insert.setString(6, user.getRole());
            insert.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        String query = "update user password = ?, firstName = ?, lastName = ?, phone = ? where id = ?";
        try {
            update = conn.prepareStatement(query);
            update.setString(1, user.getPassword());
            update.setString(2, user.getFirstName());
            update.setString(3, user.getLastName());
            update.setString(4, user.getPhone());
            update.setInt(5, user.getId());
            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String query = "delete from user where id = " + id;
        try {
            conn.createStatement().executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
