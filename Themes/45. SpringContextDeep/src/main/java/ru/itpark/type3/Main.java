package ru.itpark.type3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itpark.type3.interfaces.Terminal;
import ru.itpark.type3.сonfig.AppContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
    Terminal terminal = context.getBean(Terminal.class);
    terminal.giveMoney(80);
  }
}
