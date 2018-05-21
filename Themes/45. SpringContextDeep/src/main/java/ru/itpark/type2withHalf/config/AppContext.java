package ru.itpark.type2withHalf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itpark.type2withHalf.impl.PrinterImpl;
import ru.itpark.type2withHalf.interfaces.CheckTemplate;
import ru.itpark.type2withHalf.interfaces.Printer;

@Configuration
public class AppContext {

  @Autowired
  private CheckTemplate checkTemplate;

  @Bean
  public Printer printer() {
    return new PrinterImpl(checkTemplate);
  }
}
