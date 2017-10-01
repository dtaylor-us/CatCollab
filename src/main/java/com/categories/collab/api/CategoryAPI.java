package com.categories.collab.api;

import com.categories.collab.domain.Category;
import com.categories.collab.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {
    Logger logger = Logger.getLogger(CategoryAPI.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Category> getAll() {
        return categoryService.getCategoryList();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category getById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Category save(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Boolean delete(@PathVariable int id) {

        try {
            categoryService.deleteCategory(id);
            return true;
        } catch (Exception ex) {
            logger.info(ex);
            return false;
        }
    }
}
