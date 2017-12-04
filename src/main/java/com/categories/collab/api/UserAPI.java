package com.categories.collab.api;

import com.categories.collab.domain.User;
import com.categories.collab.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserAPI {
    Logger logger = Logger.getLogger(UserAPI.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<User> getAll() {
        return userService.getUserList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return true;
        } catch (Exception ex) {
            logger.info(ex);
            return false;
        }
    }
}
