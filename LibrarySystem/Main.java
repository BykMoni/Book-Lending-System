import manager.*;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        BorrowerManager borrowerManager = new BorrowerManager();
        LendingManager lendingManager = new LendingManager(bookManager, borrowerManager);
        OverdueMonitor overdueMonitor = new OverdueMonitor();
        ReportGenerator reportGenerator = new ReportGenerator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== EBENEZER LIBRARY SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Borrower");
            System.out.println("4. View Borrowers");
            System.out.println("5. Lend Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Transactions");
            System.out.println("8. View Overdue Books");
            System.out.println("9. Generate Reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    bookManager.addBook(scanner);
                    break;
                case 2:
                    bookManager.displayBooks();
                    break;
                case 3:
                    borrowerManager.addBorrower(scanner);
                    break;
                case 4:
                    borrowerManager.displayBorrowers();
                    break;
                case 5:
                    lendingManager.lendBook(scanner);
                    break;
                case 6:
                    lendingManager.returnBook(scanner);
                    break;
                case 7:
                    lendingManager.displayTransactions();
                    break;
                case 8:
                    overdueMonitor.checkOverdueBooks(lendingManager);
                    break;
                case 9:
                    reportGenerator.generateReports(bookManager, borrowerManager, lendingManager);
                    break;
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
