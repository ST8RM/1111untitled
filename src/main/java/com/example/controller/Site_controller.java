package com.example.controller;

import com.example.repository.Repos;
import com.example.models.Name1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

//@RequestMapping используется для мапинга (связывания) с URL для всего класса или для конкретного метода обработчика. Аннотация Controller определяет класс как Контроллер Spring MVC. ... Вы можете определить любой другой метод как обработчик всех POST-запросов по данному URL-адресу.
@Controller
//Контроллер - это класс, предназначенный для непосредственной обработки запросов от клиента и возвращения результатов.
public class Site_controller {

    @Autowired
    private Repos repos;


    //@Transactional уровни изоляции транзакции
    @GetMapping("/market")
    public String markt(Model model) {
        Iterable<Name1> name1 = repos.findAll();
        model.addAttribute("name1", name1);
        return ("blocks/market");


    }

    @GetMapping("/market/add")
// @GetMapping — это просто аннотация которая содержит @RequestMapping(method = RequestMethod. GET). Она также позволяет более глубоко настроить метод-обработчик. По умолчанию аннотация принимает путь до метода.
    //какие еще используются параметры анотациях
    public String categ(Model model) {
        return ("blocks/addProduct");
    }

    @PostMapping("/market/add")
//@PostMapping -это составная аннотация, которая действует как ярлык для @RequestMapping(method = RequestMethod.POST
    public String category(@RequestParam String name, @RequestParam String description, @RequestParam String price, Model model) {//@RequestBody
        Name1 name1 = new Name1(name, description, price);
        repos.save(name1);
        return "redirect:/market";
    }


    @GetMapping("/market/{id}")
    public String NewsInfo(@PathVariable(value = "id") long id, Model model) {
        Optional<Name1> post = repos.findById(id);
        ArrayList<Name1> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return ("blocks/Market_Details");
    }

    @GetMapping("/market/{id}/edit")
    public String NewsEdit(@PathVariable(value = "id") long id, Model model) {
        Optional<Name1> post = repos.findById(id);
        ArrayList<Name1> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return ("blocks/Market_Edit");
    }

    @PostMapping("/market/{id}/edit")
    public String NewsPostEdd(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String descriptions, @RequestParam String price, Model model) {
        Name1 name1 = repos.findById(id).orElseThrow();
        name1.setName(name);
        name1.setDescription(descriptions);
        name1.setPrice(price);
        repos.save(name1);
        return "redirect:/market";
    }

    @PostMapping("/market/{id}/delete")
    public String NewsPostdel(@PathVariable(value = "id") long id, Model model) {
        Name1 name1 = repos.findById(id).orElseThrow();
        repos.delete(name1);
        return "redirect:/market";
    }

}


