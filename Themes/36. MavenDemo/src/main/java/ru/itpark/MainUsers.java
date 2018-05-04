package ru.itpark;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itpark.models.Car;
import ru.itpark.models.User;
import ru.itpark.repository.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainUsers {

  private static final String DB_USER = "postgres";
  private static final String DB_PASSWORD = "Zaq12wsx";
  private static final String DB_URL = "jdbc:postgresql://localhost:5432/it_park_group_5";

  public static void main(String[] args) throws SQLException {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUsername(DB_USER);
    dataSource.setPassword(DB_PASSWORD);
    dataSource.setUrl(DB_URL);

    UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
    User rustem = User.builder()
        .name("Рустем")
        .age(27)
        .height(1.70)
        .build();

    usersRepository.save(rustem);

    List<User> users = usersRepository.findAll();
    System.out.println(users);

  }
}
