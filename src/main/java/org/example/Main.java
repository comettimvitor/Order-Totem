package org.example;

import org.example.view.KitchenScreen;
import org.example.view.OrderTotem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OrderTotem orderTotem = new OrderTotem();
        orderTotem.setVisible(true);
    }
}