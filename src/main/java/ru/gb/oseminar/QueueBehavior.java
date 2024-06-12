package ru.gb.oseminar;

import java.util.List;

public interface QueueBehavior {
    void takeInQueue(Customer customer, List<Customer> queue);
    void takeOrders(List<Customer> queue);
    void giveOrders(List<Customer> queue);
}