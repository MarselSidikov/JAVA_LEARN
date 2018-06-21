package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itpark.service.services.AuthenticationService;

@Controller
public class ProfileController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/")
    public String profilePage(Authentication authentication, ModelMap model) {
        if (authentication == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("user",
                    authenticationService.getUserByAuthentication(authentication));
            return "Profile";
        }
    }
}
