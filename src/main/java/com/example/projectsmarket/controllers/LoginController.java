package com.example.projectsmarket.controllers;

import com.example.projectsmarket.dtos.NewProjectDTO;
import com.example.projectsmarket.services.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String successPage(Model model) {
        var pos = service.getUserPosition();
        model.addAttribute("position", service.getUserPosition());
        switch (pos) {
            case "STUDENT" -> model.addAttribute("newProjectDTO", new NewProjectDTO());
            case "TEACHER" -> model.addAttribute("allProjects", service.getAllAvailableProjects());
            case "ADMIN" -> model.addAttribute("delete", "deletew");
        }
        return pos.toLowerCase();
    }

    @PostMapping("/add")
    public String addProject(@ModelAttribute("newProjectDTO") NewProjectDTO newProjectDTO, Model model) {
        service.addProject(newProjectDTO);
        model.addAttribute("position", service.getUserPosition());
        return "student";
    }





    @PostMapping("/mark")
    public String markProject(@ModelAttribute("newProjectDTO") NewProjectDTO newProjectDTO, Model model) {
        service.addProject(newProjectDTO);
        model.addAttribute("position", service.getUserPosition());
        return "teacher";
    }

}
