package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController{

        @GetMapping("/main")
        public String greeting(Model model) {
            model.addAttribute("title", "Главная страница");
            return "blocks/MainPackage";
        }
       @GetMapping("/about")
       public String greeting1(Model model) {
           model.addAttribute("title", "Contacts");
           return "blocks/about";
    }
}



