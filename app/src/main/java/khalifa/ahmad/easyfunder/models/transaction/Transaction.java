package khalifa.ahmad.easyfunder.models.transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Transaction implements Serializable {
    private Date date;
    private double totalAmount;
    private ArrayList<SpendingCategory> usedSpendingCategories;

    public Transaction(
            Date date,
            double totalAmount,
            ArrayList<SpendingCategory> usedSpendingCategories){
        this.date = date;
        this.totalAmount = totalAmount;
        this.usedSpendingCategories = usedSpendingCategories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<SpendingCategory> getUsedSpendingCategories() {
        return usedSpendingCategories;
    }

    public void setUsedSpendingCategories(ArrayList<SpendingCategory> usedSpendingCategories) {
        this.usedSpendingCategories = usedSpendingCategories;
    }
}
