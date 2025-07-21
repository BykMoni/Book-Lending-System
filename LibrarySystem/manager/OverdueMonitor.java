package manager;

import model.Transaction;
import structure.MyArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class OverdueMonitor {
    public void checkOverdueBooks(LendingManager lendingManager) {
        MyArrayList<Transaction> transactions = lendingManager.getTransactions();
        System.out.println("Overdue Books:");
        for (int i = 0; i < transactions.size(); i++) {
            Transaction tx = transactions.get(i);
            if (!tx.isReturned()) {
                long days = ChronoUnit.DAYS.between(tx.getBorrowDate(), LocalDate.now());
                if (days > 14) {
                    System.out.println(tx.getBook().getTitle() + " is overdue by " + (days - 14) + " days.");
                }
            }
        }
    }
}
