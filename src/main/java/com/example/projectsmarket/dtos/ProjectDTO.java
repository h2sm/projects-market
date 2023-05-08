package com.example.projectsmarket.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO implements Serializable {
    private Long projectId;
    private String projectName;
    private String projectDescription;
    private String studentName;
    private List<Integer> marks;
}