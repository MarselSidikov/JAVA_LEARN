package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.services.UsersService;

import java.util.List;

@Controller
public class UsersController {

  @Autowired
  private UsersService service;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String getUsersPage(ModelMap model) {
    List<String> names = service.getAllNames();
    model.addAttribute("names", names);
    return "UsersPage";
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public String addUser(UserForm user) {
    service.addUser(user);
    return "redirect:/users";
  }
}
