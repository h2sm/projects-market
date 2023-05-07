package com.example.projectsmarket.repositories;

import com.example.projectsmarket.entities.StudentProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProjectRepository extends JpaRepository<StudentProjectEntity, Long> {
}
