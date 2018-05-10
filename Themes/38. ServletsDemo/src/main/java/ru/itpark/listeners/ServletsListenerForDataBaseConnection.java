package ru.itpark.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ServletsListenerForDataBaseConnection implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    Properties properties = new Properties();
    try {
      properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/db.properties"));
      String url = properties.getProperty("db.url");
      String username = properties.getProperty("db.username");
      String password = properties.getProperty("db.password");
      String className = properties.getProperty("db.driver");

      Class.forName(className);

      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setUrl(url);
      dataSource.setDriverClassName(className);
      dataSource.setUsername(username);
      dataSource.setPassword(password);

      servletContextEvent.getServletContext().setAttribute("dataSource", dataSource);
    } catch (IOException | ClassNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
