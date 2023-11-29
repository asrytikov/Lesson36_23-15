package com.example.lesson36.controllers;

import com.example.lesson36.LoggedUserManagementService;
import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(){
        String username = loggedUserManagementService.getName();
        if (username == null){
            return "redirect:/";
        }
        return "main.html";
    }
}
