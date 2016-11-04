package khalifa.ahmad.easyfunder.models.charity.builders;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.charity.Metrics;

public class CharityBuilder {
    private String name;
    private int category;
    private double rate;
    private String mission;
    private boolean supported;
    private Metrics metrics;

    public CharityBuilder name(String name){
        this.name = name;
        return this;
    }

    public CharityBuilder category(int category){
        this.category = category;
        return this;
    }

    public CharityBuilder rate(double rate){
        this.rate = rate;
        return this;
    }

    public CharityBuilder mission(String mission){
        this.mission = mission;
        return this;
    }

    public CharityBuilder metrics(Metrics metrics){
        this.metrics = metrics;
        return this;
    }

    public Charity build(){
        return new Charity(
                this.name,
                this.category,
                this.rate,
                this.mission,
                this.metrics
        );
    }

}
