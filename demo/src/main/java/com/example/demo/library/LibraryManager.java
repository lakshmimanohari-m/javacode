package com.example.demo.library;

import model.Book;

public class LibraryManager {
    public void issueBook(Book book, User user) {
        System.out.println("Issuing " + book + " to " + user);
        book.displayInfo();
        user.displayUser();
    }
}

