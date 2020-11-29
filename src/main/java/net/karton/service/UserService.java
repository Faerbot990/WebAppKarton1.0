package net.karton.service;

import net.karton.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getOne(Long id);

    User findByEmail(String email);

    boolean addUser(User user);

    void sendMessage(User user);

    List<User> findAll();

    void userSave(String username, Map<String, String> form, User user);

    void updateProfile(User user, String password);

    User findByUsername(String username);

    User save(User user);
}
