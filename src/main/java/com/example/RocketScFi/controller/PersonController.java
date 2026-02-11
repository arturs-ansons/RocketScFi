package com.example.RocketScFi.controller;

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

    private final List<Person> persons = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("person", new Person());
        return "new-person";
    }

    @PostMapping
    public String createPerson(@ModelAttribute Person person) {
        person.setId(DataStore.personCounter.incrementAndGet());
        DataStore.persons.add(person);
        return "redirect:/spacecrafts";
    }
}
