package com.example.projectsmarket.services;

import com.example.projectsmarket.config.ContextUtil;
import com.example.projectsmarket.dtos.NewProjectDTO;
import com.example.projectsmarket.dtos.ProjectDTO;
import com.example.projectsmarket.dtos.swapper.ProjectEntitySwapper;
import com.example.projectsmarket.entities.ProjectMarksEntity;
import com.example.projectsmarket.entities.StudentProjectEntity;
import com.example.projectsmarket.repositories.ProjectMarksRepository;
import com.example.projectsmarket.repositories.StudentProjectRepository;
import com.example.projectsmarket.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectsService {
    private final StudentProjectRepository projectsRepository;
    private final ProjectMarksRepository marksRepository;
    private final UserRepository userRepository;
    private final ProjectEntitySwapper swapper;

    @Transactional
    public void addProject(NewProjectDTO dto) {
        var student = userRepository.findUserEntityByUserEmailEquals(ContextUtil.getAuthorizedUserName());
        var project = StudentProjectEntity.builder()
                .projectId(null)
                .projectName(dto.getProjectName())
                .projectDescription(dto.getProjectDescription())
                .studentEntity(student)
                .build();
        projectsRepository.save(project);
    }

    @Transactional
    public void deleteProject(long projectId) {
        projectsRepository.deleteById(projectId);
    }

    @Transactional
    public void setRatingToProject(long projectId, int mark) {
        var project = projectsRepository.findById(projectId).get();
        var teacherEntity = userRepository.findUserEntityByUserEmailEquals(ContextUtil.getAuthorizedUserName());
        var markEntity = ProjectMarksEntity.builder()
                .markId(null)
                .teacherEntity(teacherEntity)
                .studentProject(project)
                .mark(mark)
                .build();
        marksRepository.save(markEntity);
    }

    public List<ProjectDTO> getAllAvailableProjects(){
        var projectsList = projectsRepository.findAll();
        return projectsList.stream().map(swapper::toDTO).collect(Collectors.toList());
    }


}
