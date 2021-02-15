import java.util.ArrayList;

public class Project {
    private String name;
    private String description;
    private Double initialCost;

    public Project() {
        this("Project", "Description", 0.00);
    }

    public Project(String name) {
        this(name, "Description", 0.00);
    }

    public Project(String name, String description) {
        this(name, description, 10.00);
    }

    public Project(String name, String description, Double initialCost) {
        this.setName(name);
        this.setDescription(description);
        this.setInitialCost(initialCost);
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInitialCost(Double initialCost) {
        this.initialCost = initialCost;
    }

    // Getters

    public String getProject() {
        return this.getName() + " ($" + this.getInitialCost() + ") : " + this.getDescription();
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getInitialCost() {
        return this.initialCost;
    }
}
