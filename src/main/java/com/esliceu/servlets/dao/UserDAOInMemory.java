package com.esliceu.servlets.dao;

import com.esliceu.servlets.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOInMemory implements UserDAO {
    private static final List<User> users = new ArrayList<>();

    @Override
    public boolean addUser(User user) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(user.getUsername())) {
                return false; // usuario ya existe
            }
        }
        users.add(user);
        return true;
    }

    @Override
    public boolean checkUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
