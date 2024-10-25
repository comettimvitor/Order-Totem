package org.example.controller;

import org.example.model.Order;

import java.util.*;

/**
 * Class that manages and handle operations related to orders.
 */
public class OrderService {
    private List<Order> orders;
    private Set<Integer> generatedNumbers = new HashSet<>();

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Generates a unique order ID within the range of 10000 to 99999.
     * Ensures that the generated ID is unique by storing it in a set.
     *
     * @return a number that becomes the ID of an order.
     */
    public Set<Integer> generateOrderId() {
        Random random = new Random();
        int randomNumber;

        randomNumber = 10000 + random.nextInt(90000);

        generatedNumbers.add(randomNumber);

        return generatedNumbers;
    }
}
