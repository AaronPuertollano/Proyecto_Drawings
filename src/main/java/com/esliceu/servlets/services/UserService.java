package com.esliceu.servlets.services;

import com.esliceu.servlets.dao.UserDAO;
import com.esliceu.servlets.dao.UserDAOInMemory;
import com.esliceu.servlets.models.User;

public class UserService {
    private static UserService instance;
    private final UserDAO userDAO;

    private UserService() {
        this.userDAO = new UserDAOInMemory();
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean registerUser(String name, String username, String password) {
        User newUser = new User(name, username, password);
        return userDAO.addUser(newUser);
    }

    public boolean validateUser(String username, String password) {
        return userDAO.checkUser(username, password);
    }

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }
}

