package ru.itpark.hibernate.demo.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.itpark.hibernate.demo.models.Car;
import ru.itpark.hibernate.demo.models.User;

import java.util.Arrays;


public class Main {
  public static void main(String[] args) {
    SessionFactory sessionFactory =
        new Configuration()
        .configure("ru.itpark/hibernate.cfg.xml")
        .buildSessionFactory();

    Session session = sessionFactory.openSession();
//    User user = User.builder()
//        .login("marsel")
//        .age(24)
//        .name("Марсель Сидиков")
//        .friendsCount(3)
//        .build();
//
//    session.beginTransaction();
//    session.persist(user);
//    session.getTransaction().commit();
//    session.beginTransaction();
//    user.setName("Не марсель");
//    user.setId(10L);
//    session.persist(user);
//    session.getTransaction().commit();
//    Query<User> userQuery =
//        session.createQuery("from User user where user.id = ?", User.class);
//
//    userQuery.setParameter(0, 1L);
//
//    User user = userQuery.getSingleResult();
//    System.out.println(user);
    User user = User.builder()
        .login("rustem")
        .age(27)
        .name("Рустем Фаттахов")
        .friendsCount(1000)
        .build();

    Car bmw = Car.builder()
        .model("BMW")
        .build();

    session.beginTransaction();
    session.persist(bmw);
    user.setCars(Arrays.asList(bmw));
    session.persist(user);
    session.getTransaction().commit();
    session.close();
    session.flush();
    System.out.println(bmw.getOwner());

//    Query<Car> carQuery = session.createQuery("from Car car", Car.class);
//    List<Car> cars = carQuery.getResultList();
//    System.out.println(cars);
  }
}
