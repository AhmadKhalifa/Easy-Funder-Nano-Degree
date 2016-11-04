package khalifa.ahmad.easyfunder.models.charity;

import java.io.Serializable;

public class Charity implements Serializable {
    public static int CATEGORY_ANIMALS = 0;
    public static int CATEGORY_ARTS = 1;
    public static int CATEGORY_COMMUNITY = 2;
    public static int CATEGORY_EDUCATION = 3;
    public static int CATEGORY_ENVIRONMENT = 4;
    public static int CATEGORY_HEALTH = 5;
    public static int CATEGORY_RESEARCH = 6;

    public static String[] CATEGORIES = new String[] {
            "Animals",
            "Arts, and Culture",
            "Community",
            "Education",
            "Environment",
            "Health",
            "Research"
    };

    private String name;
    private int category;
    private double rate;
    private String mission;
    private boolean supported;
    private Metrics metrics;

    public Charity(
            String name,
            int category,
            double rate,
            String mission,
            Metrics metrics){
        this.name = name;
        this.category = category;
        this.rate = rate;
        this.mission = mission;
        this.supported = false;
        this.metrics = metrics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public boolean isSupported() {
        return supported;
    }

    public void setSupported(boolean supported) {
        this.supported = supported;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }
}
