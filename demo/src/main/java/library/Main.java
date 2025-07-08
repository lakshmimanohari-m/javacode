package library;

import library.Book;
import library.User;
import library.LibraryManager;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("1984", "George Orwell");
        User user = new User("Alice");
        LibraryManager manager = new LibraryManager();
        manager.issueBook(book, user);
    }
}

