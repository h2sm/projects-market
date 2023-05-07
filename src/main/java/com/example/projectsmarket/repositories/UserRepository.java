package com.example.projectsmarket.repositories;

import com.example.projectsmarket.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByUserEmailEquals(String userEmail);
}
