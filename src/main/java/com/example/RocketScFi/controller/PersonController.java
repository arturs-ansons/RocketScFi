package com.example.RocketScFi.controller;

import com.example.RocketScFi.dto.PersonDTO;
import com.example.RocketScFi.service.PersonService;
import org.springframework.ui.Model;
import com.example.RocketScFi.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import com.example.RocketScFi.store.DataStore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "new-person";
    }

    @PostMapping
    public String createPerson(@ModelAttribute PersonDTO person) {
        personService.save(person);
        return "redirect:/spacecrafts";
    }
}
