package ru.itpark.rest.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Generator {
  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      String password = "qwerty00" + i;
      String hash = new BCryptPasswordEncoder().encode(password);
      System.out.println(hash);
    }
  }
}
