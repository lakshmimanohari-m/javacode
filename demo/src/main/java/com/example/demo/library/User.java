package com.example.demo.library;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void displayUser() {
        System.out.println("User: " + name);
    }
}

