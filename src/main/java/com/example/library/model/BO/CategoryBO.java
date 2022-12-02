package com.example.library.model.BO;

import com.example.library.model.DAO.CategoryDAO;
import com.example.library.model.entity.Category;

import java.util.List;

public class CategoryBO {
    private CategoryDAO categoryDAO;

    public CategoryBO() {
        categoryDAO = new CategoryDAO();
    }

    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    public void save(Category category) {
        categoryDAO.save(category);
    }

    public void update(Category category) {
        categoryDAO.update(category);
    }

    public void delete(Integer id) {
        categoryDAO.delete(id);
    }

    public int getTotalCategories() {
        return getCategories().size();
    }

    public String getNameById(Integer id) {
        for (Category category : getCategories()) {
            if(category.getId() == id) {
                return category.getName();
            }
        }
        return null;
    }


    public Category getCategoryById(Integer id) {
        for(Category category : getCategories()) {
            if(category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
