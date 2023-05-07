package com.example.projectsmarket.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "user_id")
    private UserEntity studentEntity;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_description")
    private String projectDescription;
}
