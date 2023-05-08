package com.example.projectsmarket.dtos.swapper;

public interface EntityToDTO <E,D>{
    D toDTO(E e);
    E toEntity(D d);
}
