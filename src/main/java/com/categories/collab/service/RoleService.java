package com.categories.collab.service;

import com.categories.collab.domain.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Iterable<Role> getRoleList();

    Role getRoleById(Integer id);

    Role saveRole(Role role);

    Iterable<Role> saveRoleList(Iterable<Role> roles);

    void deleteRole(Integer id);

}
