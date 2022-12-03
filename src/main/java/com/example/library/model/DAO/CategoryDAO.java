package com.example.library.model.DAO;

import com.example.library.model.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private Connection conn;
    private PreparedStatement insert = null;
    private PreparedStatement update = null;

    public CategoryDAO() {
        try {
            conn = ConnectDatabase.getMySQLConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        String sql = "select * from category";
        try {
            ResultSet resultSet = conn.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                categories.add(new Category(id, name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  categories;
    }

    public void save(Category category) {
        String query = "insert into category(name) values (?)";
        try {
            insert = conn.prepareStatement(query);
            insert.setString(1, category.getName());
            insert.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Category category) {
        String query = "update category set name = ? where id = ?";
        try {
            update = conn.prepareStatement(query);
            update.setString(1, category.getName());
            update.setInt(2, category.getId());
            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String query = "delete from category where id = " + id;
        try {
            conn.createStatement().execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
