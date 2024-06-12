package ru.gb.oseminar;

import java.util.ArrayList;
import java.util.List;

public class Supermarket implements SupermarketBehavior {
    private final List<Customer> queue;
    private final QueueBehavior queueBehavior;
    private final List<CustomerObserver> observers;

    public Supermarket(QueueBehavior queueBehavior) {
        this.queue = new ArrayList<>();
        this.queueBehavior = queueBehavior;
        this.observers = new ArrayList<>();
    }

  @Override
public void acceptToSupermarket(Customer customer) {
    System.out.println(customer.getName() + " вошёл в магазин");
    takeInQueue(customer);
    customer.addObserver(new CustomerObserver() {
        @Override
        public void update(Customer customer, Customer.CustomerEvent event) {
            if (event == Customer.CustomerEvent.ORDER_RECEIVED) {
                System.out.println(customer.getName() + ", ваш заказ исполнен!");
            }
        }
    });
    observers.addAll(customer.getObservers());
}
    @Override
    public void releaseFromSupermarket(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer.getName() + " покинул магазин");
            queue.remove(customer);
        }
    }

    private void takeInQueue(Customer customer) {
        queueBehavior.takeInQueue(customer, queue);
    }

    private void takeOrders() {
        queueBehavior.takeOrders(queue);
    }

    private void giveOrders() {
        queueBehavior.giveOrders(queue);
    }

    private void releaseFromQueue() {
        List<Customer> releasedCustomers = new ArrayList<>();
        for (Customer customer : queue) {
            if (customer.isOrderReceived()) {
                releasedCustomers.add(customer);
                System.out.println(customer.getName() + " покинул очередь и готов покинуть магазин");
            }
        }
        releaseFromSupermarket(releasedCustomers);
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
}