package com.example.RocketScFi.controller;

import com.example.RocketScFi.model.Spacecraft;
import com.example.RocketScFi.service.RocketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpacecraftController {

    private final RocketService rocketService;

    public SpacecraftController(RocketService rocketService) {
        this.rocketService = rocketService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("spacecraft", new Spacecraft());
        model.addAttribute("spacecrafts", rocketService.getSpacecrafts());
        return "index";
    }

    @PostMapping("/items")
    public String save(@ModelAttribute Spacecraft spacecraft) {
        rocketService.createSpacecraft(
                spacecraft.getName(),
                spacecraft.getMass(),
                spacecraft.getManufacturer()
        );
        return "redirect:/";
    }
}
