package com.categories.collab.controllers;

import com.categories.collab.common.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @RequestMapping(value = "/contact")
    public String contactPage(Model model) {
        Utils.displayUserName(model);
        return "contact";
    }
}