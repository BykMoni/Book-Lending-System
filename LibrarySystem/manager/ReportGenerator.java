package manager;

public class ReportGenerator {
    public void generateReports(BookManager bookManager, BorrowerManager borrowerManager, LendingManager lendingManager) {
        System.out.println("=== REPORT ===");
        bookManager.displayBooks();
        borrowerManager.displayBorrowers();
        lendingManager.displayTransactions();
    }
}
