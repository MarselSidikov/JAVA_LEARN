package ru.itpark.custom;

public class MyException extends RuntimeException {
  private static final String myExceptionText = "You're LOSER";

  public MyException(String message) {
    super(myExceptionText + " " + message);
  }
}
