package com.example.springproject.controller;

import com.example.springproject.entity.Person;
import com.example.springproject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String homePageGet() {
        return "main";
    }

    @PostMapping("/")
    public String addPersonDate(@RequestParam String email, @RequestParam String password, Model model) {
        personService.personSaveDate(email,password);
        return "redirect:/person";
    }

    @GetMapping("/person")
    public String personGetPage(Model model) {
        Iterable<Person> people = personService.getAllPerson();
        model.addAttribute("people",people);
        return "person";
    }


}
