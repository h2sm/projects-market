package com.example.projectsmarket.controllers;

import com.example.projectsmarket.dtos.DeleteProjectDTO;
import com.example.projectsmarket.dtos.MarkProjectDTO;
import com.example.projectsmarket.dtos.NewProjectDTO;
import com.example.projectsmarket.services.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            case "TEACHER" ->{
                model.addAttribute("allProjects", service.getAllAvailableProjects());
                model.addAttribute("markDTO", new MarkProjectDTO());
            }
            case "ADMIN" -> {
                model.addAttribute("allProjects", service.getAllAvailableProjects());
                model.addAttribute("deleteDTO", new DeleteProjectDTO());
            }
        }
        return pos.toLowerCase();
    }
    @GetMapping("/success")
    public String successPageAgain(Model model) {
        var pos = service.getUserPosition();
        model.addAttribute("position", service.getUserPosition());
        switch (pos) {
            case "STUDENT" -> model.addAttribute("newProjectDTO", new NewProjectDTO());
            case "TEACHER" ->{
                model.addAttribute("allProjects", service.getAllAvailableProjects());
                model.addAttribute("markDTO", new MarkProjectDTO());
            }
            case "ADMIN" -> {
                model.addAttribute("allProjects", service.getAllAvailableProjects());
                model.addAttribute("deleteDTO", new DeleteProjectDTO());
            }
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
    public String markProject(@ModelAttribute("markDTO") MarkProjectDTO mark, Model model) {
        service.setRatingToProject(mark.getProjectId(), mark.getMark());
        model.addAttribute("position", service.getUserPosition());
        model.addAttribute("allProjects", service.getAllAvailableProjects());
        model.addAttribute("markDTO", new MarkProjectDTO());
        return "redirect:/success";
    }

    @PostMapping(value = "/delete")
    public String deleteProject(@ModelAttribute("deleteDTO") DeleteProjectDTO deleteProjectDTO, Model model){
        service.deleteProject(deleteProjectDTO.getProjectId());
        model.addAttribute("position", service.getUserPosition());
        model.addAttribute("allProjects", service.getAllAvailableProjects());
        model.addAttribute("deleteDTO", new DeleteProjectDTO());
        return "redirect:/success";
    }

}
