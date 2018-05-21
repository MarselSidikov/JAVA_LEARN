package ru.itpark.type2withHalf.impl;

import ru.itpark.type2withHalf.interfaces.CheckTemplate;
import ru.itpark.type2withHalf.interfaces.Printer;

public class PrinterImpl implements Printer {

  private CheckTemplate checkTemplate;

  public PrinterImpl(CheckTemplate checkTemplate) {
    this.checkTemplate = checkTemplate;
  }

  @Override
  public void print(int sum) {
    System.out.println(checkTemplate.getTemplateFor(sum));
  }
}
