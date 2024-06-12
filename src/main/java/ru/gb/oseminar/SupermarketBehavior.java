package ru.gb.oseminar;

import java.util.List;

public interface SupermarketBehavior {
    void acceptToSupermarket(Customer customer);
    void releaseFromSupermarket(List<Customer> customers);
    void update();
}