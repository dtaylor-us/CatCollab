package com.categories.collab.repositories;

import com.categories.collab.domain.Role;
import com.categories.collab.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
