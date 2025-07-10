package com.example.demo.library;

import model.Book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell");
        User user = new User("Alice");
        LibraryManager manager = new LibraryManager();
        manager.issueBook(book, user);
    }
}

