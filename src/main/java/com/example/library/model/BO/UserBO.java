package com.example.library.model.BO;

import com.example.library.model.DAO.UserDAO;
import com.example.library.model.entity.User;

import java.util.List;

public class UserBO {

    private UserDAO userDAO;

    public UserBO() {
        userDAO = new UserDAO();
    }

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public void save(User user) {
        userDAO.save(user);
    }

    public void update(String firstName, String lastName, String phone, String username, Integer id) {
        User user = getUserById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        user.setUsername(username);
        update(user);
    }

    public void update(String password, String username) {
        User user = getUserByUsername(username);
        user.setPassword(password);
        update(user);
    }


    public void update(User user) {
        userDAO.update(user);
    }

    public void delete(Integer id) {
        userDAO.delete(id);
    }

    public boolean checkAccount(String username, String password) {
        for (User user : getUsers()) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User getUserByUsername(String username) {
        for (User user : getUsers()) {
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public User getUserById(Integer id) {
        for (User user : getUsers()) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

}
