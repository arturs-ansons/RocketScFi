package com.example.RocketScFi.controller;

import com.example.RocketScFi.dto.CrewDTO;
import com.example.RocketScFi.dto.CrewResponse;
import com.example.RocketScFi.service.CrewService;
import com.example.RocketScFi.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Controller
@RequestMapping("/crews")
public class CrewController {
    private final CrewService crewService;
    private final PersonService personService;

    public CrewController(CrewService crewService, PersonService personService) {
        this.crewService = crewService;
        this.personService = personService;
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("crew", new CrewDTO());
        model.addAttribute("persons", personService.findAll());
        return "new-crew";
    }

    @GetMapping
    public String listCrews(Model model) {
        model.addAttribute("crews", crewService.findAll());
        model.addAttribute("persons", personService.findAll());
        return "spacecrafts";
    }

    @PostMapping
    public String createCrew(@ModelAttribute CrewDTO crew) {

        // Validation: must have at least 2 members
        if (crew.getPeople().size() < 2) {
            return "redirect:/crews/new?error";
        }

        crewService.save(crew);

        return "redirect:/spacecrafts";
    }

    @GetMapping("/{id}")
    public String getCrewDetails(@PathVariable Long id, Model model) {
        CrewResponse crew = crewService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Crew not found: " + id));

        model.addAttribute("crews", List.of(crew));

        model.addAttribute("persons", personService.findAll());

        return "crews";
    }
}
