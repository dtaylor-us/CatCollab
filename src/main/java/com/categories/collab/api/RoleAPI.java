package com.categories.collab.api;

import com.categories.collab.domain.Role;
import com.categories.collab.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleAPI {
    Logger logger = Logger.getLogger(RoleAPI.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Role> getAll() {
        return roleService.getRoleList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role getById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Role save(@RequestBody Role role) {
        return roleService.saveRole(role);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        try {
            roleService.deleteRole(id);
            return true;
        } catch (Exception ex) {
            logger.info(ex);
            return false;
        }
    }
}
