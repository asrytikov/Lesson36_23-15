package com.example.lesson36;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet(){
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean logIn = loginProcessor.login();
        if (logIn){
            //model.addAttribute("message", "You are now logged in.");
            return "redirect:/main";
        }
        /*}else {
            model.addAttribute("message", "Login failed!");
        }*/

        model.addAttribute("message", "Login failed!");
        return "login.html";
    }

}
