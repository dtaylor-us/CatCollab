package com.categories.collab.controllers;

import com.categories.collab.common.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/")
    public String index(Model model) {
        Utils.displayUserName(model);
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(Model model) {
        Utils.displayUserName(model);
        return "login";
    }
}