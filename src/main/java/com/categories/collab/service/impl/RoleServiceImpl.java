package com.categories.collab.service.impl;

import com.categories.collab.domain.Role;
import com.categories.collab.domain.User;
import com.categories.collab.repositories.RoleRepository;
import com.categories.collab.repositories.UserRepository;
import com.categories.collab.service.RoleService;
import com.categories.collab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository userRepository;

    @Override
    public Iterable<Role> getRoleList() {
        return userRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public Role saveRole(Role user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<Role> saveRoleList(Iterable<Role> categories) {
        return userRepository.save(categories);
    }

    @Override
    public void deleteRole(Integer id) {
        userRepository.delete(id);
    }
}
