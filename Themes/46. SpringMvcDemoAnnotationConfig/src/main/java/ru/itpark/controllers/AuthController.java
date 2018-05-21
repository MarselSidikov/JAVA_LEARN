package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itpark.forms.UserForm;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

  @Autowired
  private UsersService service;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView getLoginPage() {
    return new ModelAndView("login");
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ModelAndView logout(HttpSession session) {
    if (session != null) {
      session.invalidate();
    }
    return new ModelAndView("redirect:/login");
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(HttpServletRequest request,
                            @ModelAttribute UserForm form) {
    User userCandidate = service.login(form);
    if (userCandidate != null) {
      HttpSession session = request.getSession();
      session.setAttribute("authenticated", true);
      session.setAttribute("currentUser", userCandidate);
      return new ModelAndView("redirect:/users");
    } else {
      return new ModelAndView("redirect:/login");
    }
  }
}
