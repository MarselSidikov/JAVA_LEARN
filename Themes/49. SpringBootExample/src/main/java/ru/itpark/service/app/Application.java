package ru.itpark.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ru.itpark.service")
@EntityScan(basePackages = "ru.itpark.service.models")
@EnableJpaRepositories(basePackages = "ru.itpark.service.repositories")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
