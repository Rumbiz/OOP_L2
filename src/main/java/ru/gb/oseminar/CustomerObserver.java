package ru.gb.oseminar;

public interface CustomerObserver {
    void update(Customer customer, Customer.CustomerEvent event);
}