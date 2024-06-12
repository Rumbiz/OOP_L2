package ru.gb.oseminar;

import java.util.ArrayList;
import java.util.List;

public abstract class Customer {
    protected final String name;
    private final List<CustomerObserver> observers;
    private boolean orderPlaced;
    private boolean orderReceived;

    public Customer(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder() {
        if (!orderPlaced) {
            orderPlaced = true;
            System.out.println(name + " разместил заказ");
            notifyObservers(CustomerEvent.ORDER_PLACED);
        }
    }

    public void receiveOrder() {
        if (orderPlaced && !orderReceived) {
            orderReceived = true;
            System.out.println(name + " получил заказ");
            notifyObservers(CustomerEvent.ORDER_RECEIVED);
        }
    }

    public void addObserver(CustomerObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(CustomerObserver observer) {
        observers.remove(observer);
    }

    public List<CustomerObserver> getObservers() {
        return observers;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }

    public boolean isOrderReceived() {
        return orderReceived;
    }

    private void notifyObservers(CustomerEvent event) {
        for (CustomerObserver observer : observers) {
            observer.update(this, event);
        }
    }

    public enum CustomerEvent {
        ORDER_PLACED,
        ORDER_RECEIVED
    }
}