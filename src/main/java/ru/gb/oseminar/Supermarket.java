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
        System.out.println(customer.getName() + " входит в магазин");
        queueBehavior.takeInQueue(customer, queue);
        customer.addObserver(new CustomerObserver() {
            @Override
            public void update(Customer customer, Customer.CustomerEvent event) {
                if (event == Customer.CustomerEvent.ORDER_RECEIVED) {
                    System.out.println(customer.getName() + ", ваш заказ выполнен!");
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

    @Override
    public void update() {
        queueBehavior.takeOrders(queue);
        queueBehavior.giveOrders(queue);
        List<Customer> releasedCustomers = new ArrayList<>();
        queueBehavior.releaseFromQueue(queue, releasedCustomers);
        releaseFromSupermarket(releasedCustomers);
    }
}