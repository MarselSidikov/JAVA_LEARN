package ru.itpark.files.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan(basePackages = "ru.itpark.files.models")
@EnableJpaRepositories(basePackages = "ru.itpark.files.repository")
@ComponentScan(value = "ru.itpark.files")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
