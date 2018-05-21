package ru.itpark.type3.сonfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "ru.itpark.type3")
@PropertySource(value = "type3\\application.properties")
public class AppContext {
}
