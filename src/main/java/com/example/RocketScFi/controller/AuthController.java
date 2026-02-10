//package com.example.RocketScFi.controller;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import jakarta.servlet.http.HttpServletRequest;
//import java.util.Map;
//
//@RestController
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//
//    public AuthController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping("/api/login")
//    public Map<String, Object> login(@RequestBody Map<String,String> body, HttpServletRequest request) {
//        String username = body.get("username");
//        String password = body.get("password");
//
//        try {
//            Authentication auth = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );
//            SecurityContextHolder.getContext().setAuthentication(auth);
//            request.getSession(true)
//                    .setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
//
//            return Map.of(
//                    "status", 200,
//                    "message", "Login successful",
//                    "user", username
//            );
//        } catch (Exception ex) {
//            return Map.of(
//                    "status", 401,
//                    "message", "Invalid username or password"
//            );
//        }
//    }
//
//
//}
package com.example.RocketScFi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}