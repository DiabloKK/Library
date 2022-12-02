package com.example.library.model.DAO;

import com.example.library.model.entity.Category;

import java.sql.*;
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
        String query = "update category name = ? where id = ?";
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
            conn.createStatement().executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Category findCategory(String id) throws SQLException {
        String sql = "Select * from category where id=?";

        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int _id = rs.getInt("id");
            String name = rs.getString("name");
            Category category = new Category(_id, name);
            return category;
        }
        return null;
    }

    public ArrayList<Category> getAllCategory() throws SQLException {
        ArrayList<Category> list = new ArrayList<Category>();
        String sql = "Select * from Category";
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Category category = new Category();
            category.setId(id);
            category.setName(name);
            list.add(category);
        }
        return list;
    }

    public int insertCategory(Category category) throws SQLException, ClassNotFoundException {
        int result = 0;
        String query = "INSERT INTO Category (name) VALUES (?)";
        try {
            update = conn.prepareStatement(query);
            update.setString(1, category.getName());
            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updateCategory(Category category) throws SQLException, ClassNotFoundException {
        int result = 0;
        String query = "Update Category set Name =? where id=? ";
        try {
            update = conn.prepareStatement(query);
            update.setString(1, category.getName());
            update.setFloat(2, category.getId());
            update.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
