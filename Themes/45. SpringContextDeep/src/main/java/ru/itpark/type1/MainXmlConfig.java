package ru.itpark.type1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.type1.interfaces.Terminal;

public class MainXmlConfig {
  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("type1/context.xml");

    Terminal terminal = context.getBean(Terminal.class);
    System.out.println(terminal.getRestOfMoney());
    terminal.giveMoney(20);
    System.out.println(terminal.getRestOfMoney());
    Terminal terminal1 = context.getBean(Terminal.class);
    System.out.println(terminal1.getRestOfMoney());
  }
}
