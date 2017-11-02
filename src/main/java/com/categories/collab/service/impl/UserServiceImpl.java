package com.categories.collab.service.impl;

import com.categories.collab.domain.User;
import com.categories.collab.repositories.UserRepository;
import com.categories.collab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User readByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveUserList(Iterable<User> categories) {
        return userRepository.save(categories);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }
}
