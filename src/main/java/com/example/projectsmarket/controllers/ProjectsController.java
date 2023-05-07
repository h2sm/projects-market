package com.example.projectsmarket.controllers;

import com.example.projectsmarket.dtos.NewProjectDTO;
import com.example.projectsmarket.services.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectsController {
    private final ProjectsService projectsService;

    @RequestMapping(method = RequestMethod.POST)
    public void addProject(@RequestBody NewProjectDTO newProjectDTO){
        projectsService.addProject(newProjectDTO);
    }

    @RequestMapping(value = "/{projectId}", method = RequestMethod.DELETE)
    public void deleteProject(@PathVariable long projectId){
        projectsService.deleteProject(projectId);

    }

    @RequestMapping(value = "/{projectId}/{mark}", method = RequestMethod.POST)
    public void setRatingToProject(@PathVariable long projectId, @PathVariable int mark){
        projectsService.setRatingToProject(projectId, mark);
    }

}
