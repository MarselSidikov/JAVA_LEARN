package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;

import java.util.List;

@Controller
public class UsersController {
  @Autowired
  private UsersService service;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ModelAndView getUsersPage() {
    ModelAndView modelAndView = new ModelAndView("users");
    List<User> users = service.getAllUsers();
    modelAndView.addObject("users", users);
    return modelAndView;
  }
}
