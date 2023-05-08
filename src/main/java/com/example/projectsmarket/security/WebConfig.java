package com.example.projectsmarket.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/hello.html").setViewName("hello");
//        registry.addViewController("/student.html").setViewName("student");
//        registry.addViewController("/admin.html").setViewName("admin");
//        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/teacher.html").setViewName("teacher");
    }
}
