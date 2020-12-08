package net.karton.service;

import net.karton.model.User;

import java.util.List;


public interface UserService {
    User getOne(Long id);

    List<User> findAll();

    User findByUsername(String username);

}
