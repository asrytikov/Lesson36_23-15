package com.example.lesson36;

import com.example.lesson36.services.LoggedUserManagementService;
import com.example.lesson36.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String username;
    private String password;

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login(){
        loginCountService.increment();
        String username = this.getUsername();
        String password = this.getPassword();
        boolean loginResult = false;
        if ("alex".equals(username) && "qweqwe".equals(password)){
            loginResult = true;
            loggedUserManagementService.setName(username);
        }
        /*}else{
            return false;
        }*/

        return loginResult;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
