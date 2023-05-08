package com.example.projectsmarket.controllers;

import com.example.projectsmarket.dtos.NewProjectDTO;
import com.example.projectsmarket.dtos.ProjectDTO;
import com.example.projectsmarket.services.ProjectsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectsController {
    private final ProjectsService projectsService;

    @RequestMapping(name = "/project",method = RequestMethod.POST)
    public void addProject(@RequestBody NewProjectDTO newProjectDTO){
        projectsService.addProject(newProjectDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteProject(@RequestParam long projectId){
        projectsService.deleteProject(projectId);

    }

    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    public void setRatingToProject(@RequestParam long projectId, @RequestParam int mark){
        projectsService.setRatingToProject(projectId, mark);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProjectDTO> getAllProjects(){
        return projectsService.getAllAvailableProjects();
    }

}
