package com.esliceu.servlets.dao;

import com.esliceu.servlets.models.User;

import java.util.List;

public interface UserDAO {

    boolean addUser(User user);
    boolean checkUser(String username, String password);
    List<User> getAllUsers();

}
