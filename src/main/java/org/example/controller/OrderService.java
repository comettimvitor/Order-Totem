package org.example.controller;

import org.example.model.Order;

import java.util.*;

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

    public Set<Integer> generateOrderId() {
        Random random = new Random();
        int randomNumber;

        randomNumber = 10000 + random.nextInt(90000);

        generatedNumbers.add(randomNumber);

        return generatedNumbers;
    }
}
