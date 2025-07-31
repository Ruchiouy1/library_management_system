import java.util.*;
import java.time.LocalDate;

public class LibrarySystem {
    static Scanner sc = new Scanner(System.in);
    static LibraryManager manager = new LibraryManager();

    public static void main(String[] args) {
        System.out.println("Welcome to the Library Subscription System!");

        if (!manager.login()) return;

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. View Subscription Plans");
            System.out.println("2. Subscribe to Plan");
            System.out.println("3. View Subscription");
            System.out.println("4. Purchase Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Payments");
            System.out.println("7. Cancel Subscription");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> manager.displayPlans();
                case 2 -> manager.subscribeToPlan();
                case 3 -> manager.viewSubscription();
                case 4 -> manager.purchaseBook();
                case 5 -> manager.returnBook();
                case 6 -> manager.viewPayments();
                case 7 -> manager.cancelSubscription(); 
                case 8 -> {
                    System.out.println("Thank you for using the system!");
                    running = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
