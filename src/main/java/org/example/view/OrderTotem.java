package org.example.view;

import org.example.controller.MenuService;
import org.example.controller.OrderService;
import org.example.model.Client;
import org.example.model.Menu;
import org.example.model.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Simulates an Order Totem, like fast-foods use to get order from clients.
 *
 * Is a JFrame-based class representing a client order interface in a restaurant system.
 * It allows clients to select menu items and enter their names to place an order.
 */
public class OrderTotem extends JFrame {
    private JPanel jPanel;
    private MenuService menuService;
    private JCheckBox checkBoxesItems;
    private JButton buttonSubmitOrder;
    private JFrame clientNameFrame;
    private JPanel clientNamePanel;
    private JTextField clientNameField;
    private JButton sendClientName;
    private JLabel labelClient;

    protected Client client;
    protected OrderService orderService;
    protected Order order;
    protected KitchenScreen kitchenScreen;

    private List<JCheckBox> checkBoxesList = new ArrayList<>();
    private List<Menu> selectedItems = new ArrayList<>();

    public OrderTotem() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 600);
        add(menuList());
        kitchenScreen = new KitchenScreen();
    }

    /**
     * Initializes the list of menu items for selection and sets up client information input fields.
     * Includes the "Submit order" button to submit the selected items.
     *
     * @return JPanel containing the menu items and submit button
     */
    private JPanel menuList() {
        jPanel = new JPanel();
        menuService = new MenuService();
        buttonSubmitOrder = new JButton("Submit order");
        clientNameFrame = new JFrame("Enter you name");
        clientNamePanel = new JPanel();
        clientNameField = new JTextField(20);
        sendClientName = new JButton("Send order");
        labelClient = new JLabel("Name: ");

        jPanel.setLayout(new GridLayout(4, 2));

        clientNameFrame.setSize(300, 100);
        clientNameFrame.setLocationRelativeTo(null);

        clientNameFrame.add(clientNamePanel);
        clientNamePanel.add(labelClient);
        clientNamePanel.add(clientNameField);
        clientNamePanel.add(sendClientName);

        sendClientName.addActionListener(e -> {
            String clientName = clientNameField.getText().trim();
            if (!clientName.isEmpty()) {
                client = new Client(clientName);
                clientNameFrame.dispose();

                orderService = new OrderService();
                order = new Order(orderService.generateOrderId(), selectedItems, client);
                orderService.addOrder(order);

                kitchenScreen.kitchenReturn(order);
            } else {
                JOptionPane.showMessageDialog(clientNameFrame, "Please, enter you name.");
            }
            clientNameField.setText("");

            for (JCheckBox checkBox : checkBoxesList) {
                checkBox.setSelected(false);
            }
        });

        for (Menu list : menuService.getListMenu()) {
            checkBoxesItems = new JCheckBox(list.toString());
            checkBoxesList.add(checkBoxesItems);
            jPanel.add(checkBoxesItems);
        }

        buttonSubmitOrder.addActionListener(e -> {
            selectedItems.clear();
            for (int i = 0; i < checkBoxesList.size(); i++) {
                JCheckBox checkBox = checkBoxesList.get(i);
                if (checkBox.isSelected()) {
                    selectedItems.add(menuService.getListMenu().get(i));
                }
            }

            if (selectedItems.isEmpty()) {
                JOptionPane.showMessageDialog(jPanel, "Please select at least one item.");
            } else {
                clientNameFrame.setVisible(true);
            }
        });

        jPanel.add(buttonSubmitOrder);
        return jPanel;
    }
}
