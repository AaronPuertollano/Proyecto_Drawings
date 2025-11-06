package com.esliceu.servlets.models;

import java.time.LocalDate;

public class Paint {

    private int id;
    private String name;
    private String data;
    private String owner;
    private LocalDate date;


    @Override
    public String toString() {
        return "Paint{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    public Paint(String name, String data, String owner, LocalDate date) {
        this.name = name;
        this.data = data;
        this.owner = owner;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
