package com.example.RocketScFi.controller;

import com.example.RocketScFi.dto.SpacecraftDTO;
import com.example.RocketScFi.model.Spacecraft;
import com.example.RocketScFi.service.SpacecraftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spacecrafts")
public class SpacecraftsController {

    private final SpacecraftService spacecraftService;

    public SpacecraftsController(SpacecraftService spacecraftService) {
        this.spacecraftService = spacecraftService;
    }

    // GET /spacecrafts -> list page
    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("spacecrafts", spacecraftService.findAll());
        return "spacecrafts"; // Thymeleaf template: spacecrafts.html
    }

    // GET /spacecrafts/new -> form page
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("spacecraft", new SpacecraftDTO());
        return "new-spacecraft"; // Thymeleaf template: new-spacecraft.html
    }

    // POST /spacecrafts -> save new spacecraft
    @PostMapping
    public String save(@ModelAttribute SpacecraftDTO spacecraft) {
        spacecraftService.save(spacecraft);
        return "redirect:/spacecrafts";
    }
}