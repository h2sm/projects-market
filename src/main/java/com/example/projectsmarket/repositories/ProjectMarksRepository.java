package com.example.projectsmarket.repositories;

import com.example.projectsmarket.entities.ProjectMarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMarksRepository extends JpaRepository<ProjectMarksEntity, Long> {
}
