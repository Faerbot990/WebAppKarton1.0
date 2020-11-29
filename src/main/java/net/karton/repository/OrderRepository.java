package net.karton.repository;

import net.karton.model.Order;
import net.karton.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository  extends JpaRepository<Order,Long> {
    List<Order> findOrderByUser(User user);
}
