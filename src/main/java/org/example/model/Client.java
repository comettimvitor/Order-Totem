package org.example.model;

/**
 * Simple class representing a client using a totem to order food.
 */
public class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
