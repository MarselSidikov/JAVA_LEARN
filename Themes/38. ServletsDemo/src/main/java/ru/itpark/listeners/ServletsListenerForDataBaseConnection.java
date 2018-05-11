package ru.itpark.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Класс, слушатель-контекста. Имеет доступ ко
// всему окружению сервлетов
// Следовательно, если здесь что-то положить в контекст
// сервлетов, оно будет доступно для всех сервлетов
// Чтобы класс действительно мог быть слушателем сервлетов
// им необходимо имплементировать интерфейс ServletContextListener
public class ServletsListenerForDataBaseConnection implements ServletContextListener {

    // метод, который вызывается при инициализации контекста
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // создаем объект Properties
        Properties properties = new Properties();
        try {
            // загружаем properties-файл
            properties.load(servletContextEvent.getServletContext().getResourceAsStream("/WEB-INF/db.properties"));
            // считываем все свойства для подключения к БД
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            String className = properties.getProperty("db.driver");
            // загружаем драйвер по его названию
            Class.forName(className);
            // создаем DataSource для подключения к БД
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl(url);
            dataSource.setDriverClassName(className);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            // кладем его в контекст всех сервлетов
            servletContextEvent.getServletContext().setAttribute("dataSource", dataSource);
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
