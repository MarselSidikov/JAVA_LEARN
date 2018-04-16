package ru.itpark.models;

import java.time.LocalDate;

public class User {
  private int id;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;

  public User(String firstName, String lastName, LocalDate birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }
}
