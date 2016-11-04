package khalifa.ahmad.easyfunder.models.transaction;

import java.io.Serializable;

public class SpendingCategory implements Serializable {
    public static String AUTOMOBILE = "Automobile";
    public static String BANK_CHARGE = "Bank Charges";
    public static String CHILDCARE = "Childcare";
    public static String CLOTHING = "Clothing";
    public static String EVENTS = "Events";
    public static String FOOD = "Food";
    public static String GIFTS = "Gifts";
    public static String HEALTH_CARE = "Health care";
    public static String INSURANCE = "Insurance";
    public static String VACATION = "Vacation";

    private String name;
    private double totalPaid;
    private boolean used;
    private double totalDonated;
    private double percentage;

    public SpendingCategory(
            String name){
        this(name, 0.00, 0.00, 0.00);
    }

    public SpendingCategory(
            String name,
            double totalPaid){
        this(name, totalPaid, 0.00, 0.00);
    }

    public SpendingCategory(
            String name,
            double totalPaid,
            double totalDonated,
            double percentage){
        this.name = name;
        this.totalPaid = totalPaid;
        this.totalDonated = totalDonated;
        this.percentage = percentage;
        this.used = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getTotalDonated() {
        return totalDonated;
    }

    public void setTotalDonated(double totalDonated) {
        this.totalDonated = totalDonated;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

}
