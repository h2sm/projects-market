package com.example.projectsmarket.dtos.swapper;

import com.example.projectsmarket.dtos.ProjectDTO;
import com.example.projectsmarket.entities.ProjectMarksEntity;
import com.example.projectsmarket.entities.StudentProjectEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProjectEntitySwapper implements EntityToDTO<StudentProjectEntity, ProjectDTO> {
    @Override
    public ProjectDTO toDTO(StudentProjectEntity studentProjectEntity) {
        return ProjectDTO.builder()
                .projectId(studentProjectEntity.getProjectId())
                .projectName(studentProjectEntity.getProjectName())
                .projectDescription(studentProjectEntity.getProjectDescription())
                .studentName(studentProjectEntity.getStudentEntity().getUsername())
                .marks(studentProjectEntity.getProjectMarks().stream().map(ProjectMarksEntity::getMark).collect(Collectors.toList()))
                .build();
    }

    @Override
    public StudentProjectEntity toEntity(ProjectDTO projectDTO) {
        return null;
    }
}
