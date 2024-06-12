package ru.gb.oseminar;
// Класс "Наблюдатель" - служит "шиной данных между остальными классами". Паттерн Observer.
public interface CustomerObserver {
    void update(Customer customer, Customer.CustomerEvent event);
}