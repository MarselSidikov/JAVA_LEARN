package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itpark.forms.UserForm;
import ru.itpark.services.UsersService;

@Controller
public class SignUpController {

  @Autowired
  private UsersService usersService;

  @RequestMapping(value = "/signUp", method = RequestMethod.GET)
  public ModelAndView getSignUpPage() {
    return new ModelAndView("signUp");
  }

  @RequestMapping(value = "/signUp", method = RequestMethod.POST)
  public ModelAndView signUp(@ModelAttribute UserForm userForm) {
    usersService.registerNewUser(userForm);
    return new ModelAndView("login");
  }
}
