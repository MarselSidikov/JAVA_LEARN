package ru.itpark.test.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("ru.itpark.test")
@EntityScan(basePackages = "ru.itpark.test.models",  basePackageClasses = Jsr310JpaConverters.class)
@EnableJpaRepositories(basePackages = "ru.itpark.test.repositories")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }
}
