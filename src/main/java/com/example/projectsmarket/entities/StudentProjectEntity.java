package com.example.projectsmarket.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "student_projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "user_id")
    private UserEntity studentEntity;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_description")
    private String projectDescription;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.REMOVE
            })
    @JoinTable(name = "project_marks",
            joinColumns = {@JoinColumn(name = "project_id"),
            }, inverseJoinColumns = @JoinColumn( name="mark_id"))
    private List<ProjectMarksEntity> projectMarks;
}
