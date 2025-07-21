package manager;

import model.*;
import structure.MyArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class LendingManager {
    private BookManager bookManager;
    private BorrowerManager borrowerManager;
    private MyArrayList<Transaction> transactions = new MyArrayList<>();

    public LendingManager(BookManager bm, BorrowerManager br) {
        this.bookManager = bm;
        this.borrowerManager = br;
    }

    public void lendBook(Scanner scanner) {
        System.out.print("Enter borrower ID: ");
        String borrowerId = scanner.nextLine();
        Borrower borrower = borrowerManager.getBorrower(borrowerId);
        if (borrower == null) {
            System.out.println("Borrower not found.");
            return;
        }

        System.out.print("Enter book ID: ");
        String bookId = scanner.nextLine();
        Book book = bookManager.getBook(bookId);
        if (book == null || !book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        Transaction tx = new Transaction(book, borrower, LocalDate.now());
        book.setAvailable(false);
        transactions.add(tx);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(Scanner scanner) {
        System.out.print("Enter book ID to return: ");
        String bookId = scanner.nextLine();

        for (int i = 0; i < transactions.size(); i++) {
            Transaction tx = transactions.get(i);
            if (tx.getBook().getId().equals(bookId) && !tx.isReturned()) {
                tx.setReturnDate(LocalDate.now());
                tx.getBook().setAvailable(true);
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("No matching borrowed record found.");
    }

    public void displayTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    public MyArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
