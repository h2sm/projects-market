package com.example.projectsmarket.config;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class ContextUtil {
    public static String getAuthorizedUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
