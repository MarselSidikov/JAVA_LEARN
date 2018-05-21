package ru.itpark.type2withHalf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.type2withHalf.interfaces.Terminal;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("type2withHalf\\context.xml");
    Terminal terminal = context.getBean(Terminal.class);
    terminal.giveMoney(50);


  }
}
