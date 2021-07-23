package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CategControl {


    @GetMapping("/pc")
    public String greeting(Model model) {
        model.addAttribute("title", "Компьютеры");
        return "blocks/pc";
    }

    @GetMapping("/notebook")
    public String greeting1(Model model) {
        model.addAttribute("title", "Ноутбуки");
        return "blocks/notebook";
    }

    @GetMapping("/smartphones")
    public String greeting2(Model model) {
        model.addAttribute("title", "Смартфоны");
        return "blocks/phones";
    }

}



