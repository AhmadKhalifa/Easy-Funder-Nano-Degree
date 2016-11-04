package khalifa.ahmad.easyfunder.models.charity;

import java.io.Serializable;

public class Metrics implements Serializable {

    private String totalContributions;
    private String totalRevenue;
    private String programExpenses;
    private String fundraisingExpenses;
    private String totalFunctionalExpenses;
    private String netAssets;

    public Metrics(
            String totalContributions,
            String totalRevenue,
            String programExpenses,
            String fundraisingExpenses,
            String totalFunctionalExpenses,
            String netAssets){
        this.totalContributions = totalContributions;
        this.totalRevenue = totalRevenue;
        this.programExpenses = programExpenses;
        this.fundraisingExpenses = fundraisingExpenses;
        this.totalFunctionalExpenses = totalFunctionalExpenses;
        this.netAssets = netAssets;
    }

    public String getTotalContributions() {
        return totalContributions;
    }

    public void setTotalContributions(String totalContributions) {
        this.totalContributions = totalContributions;
    }

    public String getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getProgramExpenses() {
        return programExpenses;
    }

    public void setProgramExpenses(String programExpenses) {
        this.programExpenses = programExpenses;
    }

    public String getFundraisingExpenses() {
        return fundraisingExpenses;
    }

    public void setFundraisingExpenses(String fundraisingExpenses) {
        this.fundraisingExpenses = fundraisingExpenses;
    }

    public String getTotalFunctionalExpenses() {
        return totalFunctionalExpenses;
    }

    public void setTotalFunctionalExpenses(String totalFunctionalExpenses) {
        this.totalFunctionalExpenses = totalFunctionalExpenses;
    }

    public String getNetAssets() {
        return netAssets;
    }

    public void setNetAssets(String netAssets) {
        this.netAssets = netAssets;
    }
}
