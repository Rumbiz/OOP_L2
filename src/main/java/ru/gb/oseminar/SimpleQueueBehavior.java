package ru.gb.oseminar;
//Реализация интерфейса "Логика Очереди". Присоединение и выход из очереди.
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

    @Override
    public void releaseFromQueue(List<Customer> queue, List<Customer> releasedCustomers) {
        for (Customer customer : queue) {
            if (customer.isOrderReceived()) {
                releasedCustomers.add(customer);
                System.out.println(customer.getName() + " покинул очередь и выходит из магазина");
            }
        }
    }
}