package ru.itpark.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;
import ru.itpark.services.UsersService;
import ru.itpark.services.UsersServiceByDataBaseImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersServlet extends HttpServlet {

  private UsersService service;

  @Override
  public void init() throws ServletException {
    service = new UsersServiceByDataBaseImpl();
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<User> users = service.findAllUsersFromDataBase();
//    PrintWriter writer = resp.getWriter();
//
//    writer.write("<html>");
//    writer.write("<head>");
//    writer.write("  <title>Users List</title>");
//    writer.write("</head>");
//    writer.write("<body>");
//    writer.write("  <table>");
//    writer.write("    <tr>");
//    writer.write("      <th>Name</th>");
//    writer.write("      <th>Age</th>");
//    writer.write("      <th>Height</th>");
//    writer.write("    </tr>");
//
//    for (User user : users) {
//      writer.write("  <tr>");
//      writer.write("    <td>" + user.getName() + "</td>");
//      writer.write("    <td>" + user.getAge() + "</td>");
//      writer.write("    <td>" + user.getHeight() + "</td>");
//      writer.write("  </tr>");
//    }
//
//    writer.write("  </table>");
//    writer.write("</body>");
//    writer.write("</html>");
    req.setAttribute("users", users);
    req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
  }
}
