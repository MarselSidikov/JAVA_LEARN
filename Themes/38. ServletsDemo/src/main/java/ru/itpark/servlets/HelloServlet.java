package ru.itpark.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
    PrintWriter writer = response.getWriter();
    String userName = request.getParameter("name");
    writer.write("<h1>Hello, " + userName + "</h1>");
  }
}
