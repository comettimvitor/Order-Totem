package org.example.model;

public class Kitchen implements Runnable{
    private Order order;

    public Kitchen(Order order) {
        this.order = order;
    }

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
