package net.karton.service;

import net.karton.model.Order;
import net.karton.model.User;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order save(Order order);

    List<Order> findOrderByUser(User user);
}
