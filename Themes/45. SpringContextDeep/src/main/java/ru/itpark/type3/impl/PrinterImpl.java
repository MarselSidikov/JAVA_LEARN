package ru.itpark.type3.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.type3.interfaces.CheckTemplate;
import ru.itpark.type3.interfaces.Printer;

@Component
public class PrinterImpl implements Printer {

  @Autowired
  private CheckTemplate checkTemplate;

  @Override
  public void print(int sum) {
    System.out.println(checkTemplate.getTemplateFor(sum));
  }
}
