package org.example.model;

/**
 * Represents a kitchen that receive orders and prepare them.
 *
 * Each instance of kitchen handles the preparation of a specific order object by running it in separated threads.
 *
 * Implements Runnable for multithreading purposes.
 */
public class Kitchen implements Runnable{
    private Order order;

    public Kitchen(Order order) {
        this.order = order;
    }

    /**
     * Executes the order preparation process.
     *
     * Calculates the time preparation based in the listed itens of an order,
     * then pauses the thread to simulate the preparation time and then sets the status "Ready", when it`s done.
     */
    @Override
    public void run() {
        try{
            System.out.println("Preparing order ID: " + order.getId() + " in Thread: " + Thread.currentThread().getName());

            int time = 0;
            for(Menu timePreparation : order.getItens()){
                time += timePreparation.getTimePreparation();
            }
            Thread.sleep(time*1000);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }

        order.setStatus("Ready!");
    }
}
