package com.categories.collab.controllers;

import com.categories.collab.common.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @RequestMapping(value = "/category")
    public String categoryPage(Model model) {
        Utils.displayUserName(model);
        return "category";
    }

    @RequestMapping(value = "/item")
    public String itemPage(Model model) {
        Utils.displayUserName(model);
        return "category-items";
    }
}