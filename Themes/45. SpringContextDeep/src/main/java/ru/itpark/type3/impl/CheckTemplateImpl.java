package ru.itpark.type3.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itpark.type3.interfaces.CheckTemplate;

import java.time.LocalDateTime;

@Component
public class CheckTemplateImpl implements CheckTemplate {

  @Value("${check.template.title}")
  private String title;

  public String getTemplateFor(int sum) {
    return title + " " + LocalDateTime.now() + " " +
        " денег снято " + sum;
  }
}
