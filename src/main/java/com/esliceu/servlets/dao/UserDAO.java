package com.esliceu.servlets.dao;

import com.esliceu.servlets.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final List<User> users = new ArrayList<>();

    // Registrar un nuevo usuario
    public static boolean addUser(User user) {
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) {
                return false; // usuario ya existe
            }
        }
        users.add(user);
        return true;
    }

    // Verificar credenciales
    public static boolean checkUser(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
