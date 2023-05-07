package com.example.projectsmarket.dtos;

import lombok.Data;
import java.io.Serializable;

@Data
public class NewProjectDTO implements Serializable {
    public String projectName;
    public String projectDescription;
}
