package ru.itpark.type2.impl;

import ru.itpark.type2.interfaces.CheckTemplate;

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
