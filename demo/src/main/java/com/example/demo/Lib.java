package com.example.demo;

import service.LibraryManager;
import model.User;
import model.Book;

public class Lib {
    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell");
        User user = new User("Alice");
        LibraryManager manager = new LibraryManager();
        manager.issueBook(book, user);
    }
}

