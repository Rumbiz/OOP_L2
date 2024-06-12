package ru.gb.oseminar;

import java.util.List;

public class SimpleQueueBehavior implements QueueBehavior {
    @Override
    public void takeInQueue(Customer customer, List<Customer> queue) {
        System.out.println(customer.getName() + " присоединился к очереди");
        queue.add(customer);
    }

    @Override
    public void takeOrders(List<Customer> queue) {
        for (Customer customer : queue) {
            if (!customer.isOrderPlaced()) {
                customer.placeOrder();
            }
        }
    }

    @Override
    public void giveOrders(List<Customer> queue) {
        for (Customer customer : queue) {
            if (customer.isOrderPlaced()) {
                customer.receiveOrder();
            }
        }
    }
}