package com.example.RocketScFi.controller;

import com.example.RocketScFi.model.Spacecraft;
import com.example.RocketScFi.service.RocketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/spacecrafts")
public class SpacecraftsController {

    private final RocketService rocketService;

    public SpacecraftsController(RocketService rocketService) {
        this.rocketService = rocketService;
    }

    // GET /spacecrafts -> list page
    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("spacecrafts", rocketService.findAllSpacecrafts());
        return "spacecrafts"; // Thymeleaf template: spacecrafts.html
    }

    // GET /spacecrafts/new -> form page
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("spacecraft", new Spacecraft());
        return "new-spacecraft"; // Thymeleaf template: new-spacecraft.html
    }

    // POST /spacecrafts -> save new spacecraft
    @PostMapping
    public String save(@ModelAttribute Spacecraft spacecraft) {
        rocketService.saveSpacecraft(
                spacecraft.getName(),
                spacecraft.getMass(),
                spacecraft.getManufacturer()
        );
        return "redirect:/spacecrafts";
    }
}