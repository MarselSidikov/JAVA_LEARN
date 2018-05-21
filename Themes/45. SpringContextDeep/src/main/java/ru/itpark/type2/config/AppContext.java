package ru.itpark.type2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ru.itpark.type2.impl.TerminalImpl;
import ru.itpark.type2.interfaces.Terminal;

@Configuration
@PropertySource("type2\\application.properties")
public class AppContext {
  @Value("${terminal.sum}")
  private int terminalSum;

  @Bean
  @Scope(value = "prototype")
  public Terminal terminal() {
    return new TerminalImpl(terminalSum);
  }
}
