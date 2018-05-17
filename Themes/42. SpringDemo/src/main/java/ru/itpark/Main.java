package ru.itpark;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("context.xml");

    MessagePrinter printer =
        context.getBean("messagePrinter", MessagePrinter.class);
    printer.print();
  }
}
