package com.example.projectsmarket.controllers;

import com.example.projectsmarket.services.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {
    private final ProjectsService service;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/success")
    public String successPage(Model model){
        var pos = service.getUserPosition();
        model.addAttribute("position", service.getUserPosition());
        return pos.toLowerCase();
    }

}
