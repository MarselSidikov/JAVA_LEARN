package ru.itpark.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.chat.forms.UserForm;
import ru.itpark.chat.services.UsersService;
import ru.itpark.chat.transfer.UserDto;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping("/users")
    public String getUsersPage(ModelMap model) {
        List<UserDto> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "Users_page";
    }

    @PostMapping("/users")
    public String addUser(UserForm user) {
        service.addUser(user);
        return "redirect:/html/sign_in.html";
    }
}
