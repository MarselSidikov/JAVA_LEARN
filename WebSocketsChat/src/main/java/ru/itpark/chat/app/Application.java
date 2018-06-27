package ru.itpark.chat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 25.01.17
 * Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication
@ComponentScan("ru.itpark")
@EnableJpaRepositories(basePackages = "ru.itpark.chat.repositories")
@EntityScan(basePackages = "ru.itpark.chat.models")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
