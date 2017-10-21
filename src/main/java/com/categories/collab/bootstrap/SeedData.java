package com.categories.collab.bootstrap;


import com.categories.collab.domain.Category;
import com.categories.collab.domain.Item;
import com.categories.collab.domain.Message;
import com.categories.collab.service.CategoryService;
import com.categories.collab.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    private Logger log = Logger.getLogger(SeedData.class);

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemService itemService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        generateCategories();
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


        Date dt1 = new Date();
        Date dt2 = new Date();
        Date dt3 = new Date();
        Date dt4 = new Date();
        Date dt5 = new Date();
        Date dt6 = new Date();

        List<Date> dates = new ArrayList<>();

        for (int i = 1; i < 5; i++){
            Date currentDate = dates.get(i);

            Calendar c = Calendar.getInstance();
            c.setTime(dates.get(i));
            c.add(Calendar.DATE, i);
             = c.getTime();
        }

        Message message = new Message("user", "Issue with category", "Hello, to whom it may concern I have been having issues with my account", initDate.);
        Message message1 = new Message("user", "Issue with category1", "Hello, to whom it may concern I have been having issues with my account", new Date());
        Message message2 = new Message("user", "Issue with category2", "Hello, to whom it may concern I have been having issues with my account", new Date());
        Message message3 = new Message("user", "Issue with category3", "Hello, to whom it may concern I have been having issues with my account", new Date());
        Message message4 = new Message("user", "Issue with category4", "Hello, to whom it may concern I have been having issues with my account", new Date());

    }

}
