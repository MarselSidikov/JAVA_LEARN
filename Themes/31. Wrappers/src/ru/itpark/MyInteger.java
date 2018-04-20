package ru.itpark;

public class MyInteger {
  private int value;

  private MyInteger(int value) {
    this.value = value;
  }
  public static MyInteger valueOf(int value) {
    return new MyInteger(value);
  }
}
