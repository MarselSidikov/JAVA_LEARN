package ru.itpark.hibernate.repository;

import ru.itpark.hibernate.demo.models.User;
import ru.itpark.hibernate.repository.config.HibernateConnector;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    UsersRepositoryHibernateImpl usersRepository =
        new UsersRepositoryHibernateImpl(HibernateConnector.getConnector().getSessionFactory());
    List<User> users = usersRepository.findAll();
    System.out.println(users);
  }
}
