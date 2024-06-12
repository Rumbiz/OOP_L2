package ru.gb.oseminar;

public class Main {
    public static void main(String[] args) {
        QueueBehavior queueBehavior = new SimpleQueueBehavior();
        Supermarket supermarket = new Supermarket(queueBehavior);
        Customer customer1 = new RegularCustomer("Ivan");
        Customer customer2 = new RegularCustomer("Vladimir");
        supermarket.acceptToSupermarket(customer1);
        supermarket.acceptToSupermarket(customer2);
        supermarket.update();
    }
}