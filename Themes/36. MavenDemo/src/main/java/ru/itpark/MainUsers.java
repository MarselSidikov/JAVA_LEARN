package ru.itpark;

import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;
import ru.itpark.repository.UsersRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainUsers {

  private static final String DB_USER = "postgres";
  private static final String DB_PASSWORD = "Zaq12wsx";
  private static final String DB_URL = "jdbc:postgresql://localhost:5432/it_park_group_5";

  public static void main(String[] args) throws SQLException {
    Connection connection =
        DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

    UsersRepository usersRepository = new UsersRepositoryImpl(connection);
    User marsel = usersRepository.find(5);
    List<User> users = usersRepository.findAll();
    System.out.println(users);
    System.out.println(marsel);
    User newUser = User.builder()
        .age(18)
        .name("Ксения")
        .build();

    System.out.println(newUser);
    usersRepository.save(newUser);
    System.out.println(newUser);
  }
}
