package com.example.RocketScFi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    // Redirect root URL to /items
    @GetMapping("/")
    public String redirectToSpacecrafts() {
        return "redirect:/spacecrafts";
    }
}