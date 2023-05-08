package com.example.projectsmarket.controllers;

import com.example.projectsmarket.dtos.NewProjectDTO;
import com.example.projectsmarket.dtos.ProjectDTO;
import com.example.projectsmarket.services.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@AllArgsConstructor
public class ProjectsController {
    private final ProjectsService projectsService;

    @RequestMapping(name = "/addProject", method = RequestMethod.POST)
    public void addProject(@ModelAttribute("newProjectDTO") NewProjectDTO newProjectDTO, BindingResult errors, Model model){
        projectsService.addProject(newProjectDTO);
    }

    @DeleteMapping(value = "/deleteProject")
    public void deleteProject(@RequestParam long projectId){
        projectsService.deleteProject(projectId);

    }

    @PostMapping(value = "/markProject")
    public void setRatingToProject(@RequestParam long projectId, @RequestParam int mark){
        projectsService.setRatingToProject(projectId, mark);
    }

    @GetMapping(value = "/allProjects")
    public List<ProjectDTO> getAllProjects(){
        return projectsService.getAllAvailableProjects();
    }

}
