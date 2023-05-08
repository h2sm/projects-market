package com.example.projectsmarket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/login")
public class LoginController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @PostMapping("/success")
    public String successPage(){
        return "hello";
    }

}
