package net.karton.service;

import net.karton.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getOne(Long id);

    List<User> findAll();

    User findByUsername(String username);

    User save(User user);
}
