package com.categories.collab.service;

import com.categories.collab.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User readByUsername(String username);

    Iterable<User> getUserList();

    User getUserById(Integer id);

    User saveUser(User user);

    Iterable<User> saveUserList(Iterable<User> users);

    void deleteUser(Integer id);

}
