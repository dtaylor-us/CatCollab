package com.categories.collab.bootstrap;


import com.categories.collab.domain.Category;
import com.categories.collab.domain.Item;
import com.categories.collab.service.CategoryService;
import com.categories.collab.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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

}
