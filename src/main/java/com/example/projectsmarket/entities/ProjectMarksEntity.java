package com.example.projectsmarket.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_marks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectMarksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mark_id")
    private Long markId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private StudentProjectEntity studentProject;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "user_id")
    private UserEntity teacherEntity;
    @Column(name = "project_mark")
    private int mark;
}
