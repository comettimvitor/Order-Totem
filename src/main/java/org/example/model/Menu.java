package org.example.model;

public class Menu {
    private String id;
    private String name;
    private String description;
    private double price;
    private int timePreparation;

    public Menu() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTimePreparation() {
        return timePreparation;
    }

    public void setTimePreparation(int timePreparation) {
        this.timePreparation = timePreparation;
    }

    @Override
    public String toString() {
        return "<html>" + "<h3>" + id + ". " + name + " - R$" + price + "</h3>" + "<br>" +
                "<h4>" + description + "</h4>" + "<br>" + "</html>";
    }
}
