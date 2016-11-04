package khalifa.ahmad.easyfunder.models.transaction.builders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.models.transaction.Transaction;

public class TransactionBuilder {
    private Date date;
    private double totalAmount;
    private ArrayList<SpendingCategory> usedSpendingCategories;

    public TransactionBuilder date(Date date){
        this.date = date;
        return this;
    }

    public TransactionBuilder totalAmount(double totalAmount){
        this.totalAmount = totalAmount;
        return this;
    }

    public TransactionBuilder usedSpendingCategories
            (ArrayList<SpendingCategory> usedSpendingCategories){
        this.usedSpendingCategories = usedSpendingCategories;
        return this;
    }

    public Transaction build(){
        return new Transaction(
                this.date,
                this.totalAmount,
                this.usedSpendingCategories
        );
    }
}
