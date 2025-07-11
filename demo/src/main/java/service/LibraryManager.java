package service;

import model.Book;
import model.User;

public class LibraryManager {
    public void issueBook(Book book, User user) {
        System.out.println("Issuing " + book + " to " + user);
        book.displayInfo();
        user.displayUser();
    }
}

