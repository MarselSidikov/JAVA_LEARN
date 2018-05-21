package ru.itpark.type2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.type2.interfaces.CheckTemplate;
import ru.itpark.type2.interfaces.Printer;
import ru.itpark.type2.interfaces.Terminal;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("type2\\context.xml");
    CheckTemplate template = context.getBean(CheckTemplate.class);
    System.out.println(template.getTemplateFor(100));
    Terminal terminal = context.getBean(Terminal.class);
  }
}
