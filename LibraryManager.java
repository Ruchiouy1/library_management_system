import java.util.*;
import java.time.LocalDate;

public class LibraryManager {
    private List<SubscriptionPlan> plans = new ArrayList<>();
    private List<String> purchasedBooks = new ArrayList<>();
    private Subscription subscription = null;

    private String username = "Ruchi"; 
    private String password = "1234";

    private Scanner sc = new Scanner(System.in); 

    public LibraryManager() {
        plans.add(new SubscriptionPlan("Basic", 100.0));
        plans.add(new SubscriptionPlan("Standard", 200.0));
        plans.add(new SubscriptionPlan("Premium", 300.0));
    }

    public boolean login() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }

    public void displayPlans() {
        System.out.println("--- Available Plans ---");
        for (int i = 0; i < plans.size(); i++) {
            System.out.println((i + 1) + ". " + plans.get(i));
        }
    }

    public void subscribeToPlan() {
        displayPlans();
        System.out.print("Choose a plan (1-" + plans.size() + "): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        if (choice < 1 || choice > plans.size()) {
            System.out.println("Invalid plan choice.");
            return;
        }
        SubscriptionPlan plan = plans.get(choice - 1);
        subscription = new Subscription(plan.getName(), plan.getPrice(), LocalDate.now());
        System.out.println("Subscribed to: " + subscription);
    }

    public void cancelSubscription() {
        if (subscription == null) {
            System.out.println("No active subscription to cancel.");
            return;
        }
        System.out.print("Are you sure you want to cancel your subscription? (yes/no): ");
        String response = sc.nextLine().toLowerCase();
        if (response.equals("yes")) {
            System.out.println("Subscription to '" + subscription.getPlanName() + "' has been cancelled.");
            subscription = null;
            purchasedBooks.clear(); 
        } else {
            System.out.println("Cancellation aborted.");
        }
    }

    public void viewSubscription() {
        if (subscription == null) {
            System.out.println("No subscription found.");
        } else {
            System.out.println("Current Subscription: " + subscription);
        }
    }

    public void purchaseBook() {
        if (subscription == null) {
            System.out.println("Please subscribe to a plan first.");
            return;
        }
        System.out.print("Enter book name to purchase: ");
        String book = sc.nextLine();
        purchasedBooks.add(book);
        System.out.println("Book purchased: " + book);
    }

    public void returnBook() {
        System.out.print("Enter book name to return: ");
        String book = sc.nextLine();
        if (purchasedBooks.remove(book)) {
            System.out.println("Book returned: " + book);
        } else {
            System.out.println("Book not found in purchased list.");
        }
    }

    public void viewPayments() {
        if (subscription == null) {
            System.out.println("No payments made.");
        } else {
            System.out.println("Payment Details: Plan - " + subscription.getPlanName() +
                ", Amount - " + subscription.getAmount() +
                ", Date - " + subscription.getStartDate());
        }
    }
}
