package ru.gb.oseminar;
//Интерфейс для логики работы очереди.
import java.util.List;

public interface QueueBehavior {
    void takeInQueue(Customer customer, List<Customer> queue);
    void takeOrders(List<Customer> queue);
    void giveOrders(List<Customer> queue);
    void releaseFromQueue(List<Customer> queue, List<Customer> releasedCustomers);
}