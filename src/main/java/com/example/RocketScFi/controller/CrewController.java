package com.example.RocketScFi.controller;

import com.example.RocketScFi.model.Crew;
import com.example.RocketScFi.store.DataStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/crews")
public class CrewController {

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("crew", new Crew());
        model.addAttribute("persons", DataStore.persons);
        return "new-crew";
    }

    @GetMapping
    public String listCrews(Model model) {
        model.addAttribute("crews", DataStore.crews);
        model.addAttribute("persons", DataStore.persons);
        return "crews";
    }

    @PostMapping
    public String createCrew(@ModelAttribute Crew crew) {

        // Validation: must have at least 2 members
        if (crew.getPeople() == null || crew.getPeople().size() < 2) {
            return "redirect:/crews/new?error";
        }

        crew.setId(DataStore.crewCounter.incrementAndGet());
        DataStore.crews.add(crew);

        return "redirect:/spacecrafts";
    }
}