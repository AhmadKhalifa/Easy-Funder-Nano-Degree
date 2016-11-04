package khalifa.ahmad.easyfunder.models.transaction.builders;

import java.io.Serializable;

import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;

public class SpendingCategoryBuilder {
    private String name;
    private double totalPaid;
    private boolean used;
    private double totalDonated;
    private double percentage;

    public SpendingCategoryBuilder name(String name){
        this.name = name;
        return this;
    }

    public SpendingCategoryBuilder totalPaid(double totalPaid){
        this.totalPaid = totalPaid;
        return this;
    }

    public SpendingCategoryBuilder totalDonated(double totalDonated){
        this.totalDonated = totalDonated;
        return this;
    }

    public SpendingCategoryBuilder percentage(double percentage){
        this.percentage = percentage;
        return this;
    }

    public SpendingCategory build(){
        return new SpendingCategory(
                this.name,
                this.totalPaid,
                this.totalDonated,
                this.percentage
        );
    }
}
