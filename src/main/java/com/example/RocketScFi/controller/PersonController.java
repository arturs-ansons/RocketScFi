package com.example.RocketScFi.controller;

import com.example.RocketScFi.dto.PersonDTO;
import com.example.RocketScFi.service.PersonService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{id}/delete")
    public String deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return "redirect:/spacecrafts";
    }
}
