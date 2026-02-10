package com.example.RocketScFi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Serve the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // returns login.html in templates
    }
}