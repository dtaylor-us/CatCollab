package com.categories.collab.api;

import com.categories.collab.domain.Category;
import com.categories.collab.domain.Item;
import com.categories.collab.service.CategoryService;
import com.categories.collab.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/item")
public class ItemAPI {
    Logger logger = Logger.getLogger(ItemAPI.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Item> getAll() {
        return itemService.getItemList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getById(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    @RequestMapping(value = "category/{id}", method = RequestMethod.GET)
    public Iterable<Item> getItemsByCategory(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        return itemService.getItemsByCategory(category);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Item save(@Valid @RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Boolean delete(@PathVariable int id) {

        try {
            itemService.deleteItem(id);
            return true;
        } catch (Exception ex) {
            logger.info(ex);
            return false;
        }
    }
}
