package ru.itpark.rest.forms;

import lombok.Data;

@Data
public class LoginPasswordForm {
  private String login;
  private String password;
}
