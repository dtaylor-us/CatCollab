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

        Category category = new Category("Super Heroes", "Super Hero Stuff", "Derek");
        categoryService.saveCategory(category);

        Item item = new Item("Superman Vs. Batman", "Lame movie", "Derek", category);
        itemService.saveItem(item);

    }

}
