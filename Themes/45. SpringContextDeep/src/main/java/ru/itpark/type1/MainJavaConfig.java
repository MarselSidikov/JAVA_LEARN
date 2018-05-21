package ru.itpark.type1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itpark.type1.config.AppContext;
import ru.itpark.type1.interfaces.CheckTemplate;
import ru.itpark.type1.interfaces.Terminal;

public class MainJavaConfig {
  public static void main(String[] args) {
    // ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
    CheckTemplate checkTemplate = context.getBean(CheckTemplate.class);
    System.out.println(checkTemplate.getTemplateFor(100));

    Terminal terminal = context.getBean("badTerminal", Terminal.class);
    System.out.println(terminal.getRestOfMoney());
    terminal.giveMoney(50);
    Terminal terminal1 = context.getBean("badTerminal", Terminal.class);
    System.out.println(terminal1.getRestOfMoney());
  }
}
