package khalifa.ahmad.easyfunder.models.charity.builders;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.charity.Metrics;

public class MetricsBuilder {
    private String totalContributions;
    private String totalRevenue;
    private String programExpenses;
    private String fundraisingExpenses;
    private String totalFunctionalExpenses;
    private String netAssets;

    public MetricsBuilder totalContributions(String totalContributions){
        this.totalContributions = totalContributions;
        return this;
    }

    public MetricsBuilder totalRevenue(String totalRevenue){
        this.totalRevenue = totalRevenue;
        return this;
    }

    public MetricsBuilder programExpenses(String programExpenses){
        this.programExpenses = programExpenses;
        return this;
    }

    public MetricsBuilder fundraisingExpenses(String fundraisingExpenses){
        this.fundraisingExpenses = fundraisingExpenses;
        return this;
    }

    public MetricsBuilder totalFunctionalExpenses(String totalFunctionalExpenses){
        this.totalFunctionalExpenses = totalFunctionalExpenses;
        return this;
    }

    public MetricsBuilder netAssets(String netAssets){
        this.netAssets = netAssets;
        return this;
    }

    public Metrics build(){
        return new Metrics(
                this.totalContributions,
                this.totalRevenue,
                this.programExpenses,
                this.fundraisingExpenses,
                this.totalFunctionalExpenses,
                this.netAssets
        );
    }
}
