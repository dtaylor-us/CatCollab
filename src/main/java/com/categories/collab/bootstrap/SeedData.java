package com.categories.collab.bootstrap;


import com.categories.collab.domain.*;
import com.categories.collab.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    private Logger log = Logger.getLogger(SeedData.class);

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private MessageService messageService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        generateUser();
    }

    private void generateCategories() {

        Category category = new Category("Seeded Category", "Description of Category", "Admin");
        categoryService.saveCategory(category);

        Item item1 = new Item("Seeded Item1", "Description of Item", "Admin", category);
        Item item2 = new Item("Seeded Item2", "Description of Item", "Admin", category);
        Item item3 = new Item("Seeded Item3", "Description of Item", "Admin", category);
        Item item4 = new Item("Seeded Item4", "Description of Item", "Admin", category);
        itemService.saveItem(item1);
        itemService.saveItem(item2);
        itemService.saveItem(item3);
        itemService.saveItem(item4);

    }


    private void generateMessages() {
        Message message = new Message("user", "Issue with category", "Hello, to whom it may concern I have been having issues with my account", new Date());
        Message message1 = new Message("user", "Issue with category1", "Hello, to whom it may concern I have been having issues with my account", new Date());
        Message message2 = new Message("user", "Issue with category2", "Hello, to whom it may concern I have been having issues with my account", new Date());
        Message message3 = new Message("user", "Issue with category3", "Hello, to whom it may concern I have been having issues with my account", new Date());
        Message message4 = new Message("user", "Issue with category4", "Hello, to whom it may concern I have been having issues with my account", new Date());

        List<Message> messages = new ArrayList<>();

        messages.add(message);
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        messages.add(message4);

        messageService.saveMessageList(messages);
    }

    private void generateUser() {
        List<User> users = new ArrayList<>();
        User user = new User("user1", "password");
        users.add(user);
        userService.saveUserList(users);

        List<Role> roles = new ArrayList<>();
        Role userRole = new Role("ROLE_USER", users);
        roles.add(userRole);
        roleService.saveRoleList(roles);

    }

}
