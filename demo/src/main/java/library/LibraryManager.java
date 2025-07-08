package library;

import library.Book;
import library.User;
public class LibraryManager {
    public void issueBook(Book book, User user) {
        System.out.println("Issuing " + book + " to " + user);
        book.displayInfo();
        user.displayUser();
    }
}

