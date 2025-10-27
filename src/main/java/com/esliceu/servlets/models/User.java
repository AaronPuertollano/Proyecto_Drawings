package com.esliceu.servlets.models;

public class User {

    String name;
    String userName;
    String password;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.userName = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
