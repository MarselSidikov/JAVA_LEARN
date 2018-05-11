package ru.itpark.servlets;

import ru.itpark.forms.UserForm;
import ru.itpark.models.User;
import ru.itpark.services.UsersService;
import ru.itpark.services.UsersServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

  private UsersService service;

  @Override
  public void init(ServletConfig config) throws ServletException {
    // достаем dataSource из контекста, в который мы ранее его положили через Listener
    DataSource dataSource = (DataSource) config.getServletContext().getAttribute("dataSource");
    // создали сервис, ему передали dataSource а он передаст его дальше
    service = new UsersServiceImpl(dataSource);
  }

  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // вытаскиваем логин
    String login = req.getParameter("login");
    // вытаскиваем пароль
    String password = req.getParameter("password");
    // создаем временный объект
    // для транпортировки данных в service-слой
    UserForm userForm = UserForm.builder()
            .login(login)
            .password(password)
            .build();
    // спрашиваем у слоя сервисов
    // есть ли пользователь с такими учетными данными
    User userCandidate = service.login(userForm);
    if (userCandidate != null) {
      // если есть, то мы создаем для
      // текущего пользователя сессию
      HttpSession session = req.getSession();
      // сессия будет сохранена в томкате
      // клиенту будет возвращена кука JSSESIONID
      // на сервере для сессии с данным ID
      // будет положен атрибут authenticated и его значение true
      session.setAttribute("authenticated", true);
      session.setAttribute("currentUser", userCandidate);
      // перенаправили запрос на /users
      resp.sendRedirect("/users");
    } else {
      resp.sendRedirect("/login");
    }


  }
}
