import java.io.Serializable;
import java.time.LocalDate;

public class Subscription implements Serializable {
    private String planName;
    private double amount;
    private LocalDate startDate;

    public Subscription(String planName, double amount, LocalDate startDate) {
        this.planName = planName;
        this.amount = amount;
        this.startDate = startDate;
    }

    public String getPlanName() {
        return planName;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Plan: " + planName + ", Amount: " + amount + ", Start Date: " + startDate;
    }
}