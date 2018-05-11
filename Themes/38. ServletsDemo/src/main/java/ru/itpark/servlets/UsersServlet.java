package ru.itpark.servlets;

import ru.itpark.forms.UserForm;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;
import ru.itpark.services.UsersServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {

  private UsersService service;

  @Override
  public void init(ServletConfig config) throws ServletException {
    DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
    service = new UsersServiceImpl(dataSource);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String login = request.getParameter("login");
    String password = request.getParameter("password");

    UserForm userForm = UserForm.builder()
        .login(login)
        .name(name)
        .password(password)
        .build();

    service.registerNewUser(userForm);

    response.sendRedirect("/users");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
    if (request.getParameter("action") != null && request.getParameter("action").equals("signUp")) {
      String colorValue = request.getParameter("color");
      if (colorValue != null) {
        Cookie colorCookie = new Cookie("color", colorValue);
        resp.addCookie(colorCookie);
      }
      request.getRequestDispatcher("/jsp/signUp.jsp").forward(request, resp);
    } else {
      List<User> users = service.getAllUsers();
      request.setAttribute("users", users);
      request.getRequestDispatcher("/jsp/users.jsp").forward(request, resp);
    }
  }
}
