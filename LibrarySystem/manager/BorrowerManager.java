package manager;

import model.Borrower;
import structure.MyHashMap;
import java.util.Scanner;

public class BorrowerManager {
    private MyHashMap<String, Borrower> borrowers = new MyHashMap<>();

    public void addBorrower(Scanner scanner) {
        System.out.print("Enter borrower ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Borrower borrower = new Borrower(id, name);
        borrowers.put(id, borrower);
        System.out.println("Borrower added successfully.");
    }

    public Borrower getBorrower(String id) {
        return borrowers.get(id);
    }

    public void displayBorrowers() {
        System.out.println("Borrower List:");
        borrowers.displayAll();
    }
}
