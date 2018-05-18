package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itpark.forms.UserForm;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OldLoginController implements Controller {

  @Autowired
  private UsersService service;

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    if (request.getMethod().equals("GET")) {
      return new ModelAndView("login");
    } else {
      String login = request.getParameter("login");
      String password = request.getParameter("password");

      UserForm userForm = UserForm.builder()
          .login(login)
          .password(password)
          .build();
      User userCandidate = service.login(userForm);
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
}
