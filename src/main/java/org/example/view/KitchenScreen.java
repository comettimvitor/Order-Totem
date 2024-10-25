package org.example.view;

import org.example.model.Kitchen;
import org.example.model.Order;

import javax.swing.*;
import java.awt.*;

public class KitchenScreen extends JFrame {
    private JPanel jPanel;
    private JTextArea jTextArea;

    public KitchenScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = screenSize.width - getWidth();
        int y = (screenSize.height - getHeight()) / 2;

        setLocation(x, y);

        jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        jTextArea = new JTextArea();
        jTextArea.setEditable(false);
        jTextArea.setBackground(Color.BLACK);
        jTextArea.setForeground(Color.GREEN);

        JScrollPane scrollPane = new JScrollPane(jTextArea);
        jPanel.add(scrollPane, BorderLayout.CENTER);

        add(jPanel);
        setVisible(true);
    }

    protected void kitchenReturn(Order order) {

        if (order != null) {
            Kitchen kitchen = new Kitchen(order);
            Thread kitchenThread = new Thread(kitchen);
            kitchenThread.start();

            SwingWorker<Void, Void> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws InterruptedException {
                    kitchenThread.join();
                    return null;
                }

                @Override
                protected void done() {
                    SwingUtilities.invokeLater(() -> {
                        jTextArea.append(order.getClient().getName() + ", your order " +
                                order.getId() + " is " + order.getStatus() + "\n");
                    });
                    System.out.println(kitchenThread.getName() + " from order id " + order.getId() + " is closing");
                }
            };
            worker.execute();
        }
    }
}
