package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.service.dto.UserDto;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.services.UsersService;

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
    return "redirect:/users";
  }

  @GetMapping("/signUp")
  public String getSignUpPage() {
    return "SignUp_page";
  }

  @GetMapping("/login")
  public String getLoginPage() {
    return "Login_page";
  }

  @PostMapping("/users/{user-id}")
  @ResponseBody
  public ResponseEntity<UserDto> changeStatus(
      @PathVariable("user-id") Long userId, @RequestParam("action") String action) {
    if (action.equals("change_status")) {
      UserDto userDto = service.changeStatus(userId);
      return ResponseEntity.ok(userDto);
    } else return ResponseEntity.notFound().build();
  }

  @GetMapping("/users/sendMail")
  public ResponseEntity<Object> sendMail(@RequestParam("email") String email) {
    return ResponseEntity.ok(service.sendMail(email));
  }
}
