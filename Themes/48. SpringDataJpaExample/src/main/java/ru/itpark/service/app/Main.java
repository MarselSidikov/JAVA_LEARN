package ru.itpark.service.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itpark.service.config.AppContext;
import ru.itpark.service.models.User;
import ru.itpark.service.repositories.UsersRepository;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new
        AnnotationConfigApplicationContext(AppContext.class);
    UsersRepository usersRepository = context.getBean(UsersRepository.class);

//    User user = User.builder()
//        .login("artyom")
//        .age(29)
//        .name("Артем")
//        .surname("Пьянов")
//        .build();

//    usersRepository.save(user);
    List<User> users = usersRepository.findAllByNameContains("Н");
    System.out.println(users);
  }
}
