package ru.itpark.type1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ru.itpark.type1.interfaces.CheckTemplate;
import ru.itpark.type1.interfaces.Terminal;
import ru.itpark.type1.impl.BadTerminalImpl;
import ru.itpark.type1.impl.CheckTemplateImpl;
import ru.itpark.type1.impl.TerminalImpl;

@PropertySource("type1/application.properties")
public class AppContext {

  @Value("${check.template.title}")
  private String checkTemplateTitle;

  @Value("${terminal.sum}")
  private int terminalSum;

  @Bean
  public CheckTemplate checkTemplate() {
    return new CheckTemplateImpl(checkTemplateTitle);
  }

  @Bean
  @Scope(value = "prototype")
  public Terminal terminal() {
    return new TerminalImpl(terminalSum);
  }

  @Bean
  public Terminal badTerminal() {
    return new BadTerminalImpl();
  }


}
