package com.example.RocketScFi.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("rocket", "Falcon 9");
        model.addAttribute("speed", 9000);
        return "index";
    }
}
