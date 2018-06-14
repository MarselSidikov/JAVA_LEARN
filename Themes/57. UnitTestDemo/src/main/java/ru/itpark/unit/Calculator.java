package ru.itpark.unit;

public class Calculator {
  public int sum(int a, int b) {
    return a + b;
  }

  public boolean isPrimary(int x) {
    if (x <= 1) {
      throw new IllegalArgumentException();
    }

    if (x == 2) {
      return true;
    }

    for (int i = 2; i <= Math.sqrt(x); i++) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}
