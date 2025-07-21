package manager;

import model.Book;
import structure.MyHashMap;
import java.util.Scanner;

public class BookManager {
    private MyHashMap<String, Book> books = new MyHashMap<>();

    public void addBook(Scanner scanner) {
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        Book book = new Book(id, title, author);
        books.put(id, book);
        System.out.println("Book added successfully.");
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public void displayBooks() {
        System.out.println("Book List:");
        books.displayAll();
    }
}
