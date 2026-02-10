package com.example.RocketScFi.controller;

import com.example.RocketScFi.model.Spacecraft;
import com.example.RocketScFi.service.RocketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class SpacecraftController {

    private final RocketService rocketService;

    public SpacecraftController(RocketService rocketService) {
        this.rocketService = rocketService;
    }

    // GET /items -> list page
    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("spacecrafts", rocketService.getSpacecrafts());
        return "items"; // Thymeleaf template: items.html
    }

    // GET /items/new -> form page
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("spacecraft", new Spacecraft());
        return "new-item"; // Thymeleaf template: new-item.html
    }

    // POST /items -> save new spacecraft
    @PostMapping
    public String save(@ModelAttribute Spacecraft spacecraft) {
        rocketService.createSpacecraft(
                spacecraft.getName(),
                spacecraft.getMass(),
                spacecraft.getManufacturer()
        );
        return "redirect:/items";
    }
}