package ru.itpark.type2withHalf.impl;

import ru.itpark.type2withHalf.interfaces.CheckTemplate;

import java.time.LocalDateTime;

public class CheckTemplateImpl implements CheckTemplate {

  private String title;

  public CheckTemplateImpl(String title) {
    this.title = title;
  }

  public String getTemplateFor(int sum) {
    return title + " " + LocalDateTime.now() + " " +
        " денег снято " + sum;
  }
}
