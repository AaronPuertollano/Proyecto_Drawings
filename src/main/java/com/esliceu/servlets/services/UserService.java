package com.esliceu.servlets.services;

import com.esliceu.servlets.dao.UserDAO;
import com.esliceu.servlets.models.User;

public class UserService {
    public boolean registerUser(String name, String username, String password) {
        User newUser = new User(name, username, password);
        return UserDAO.addUser(newUser);
    }

    public boolean validateUser(String username, String password) {
        return UserDAO.checkUser(username, password);
    }
}
