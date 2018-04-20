package ru.itpark;

public class MainHowItWorks {
  public static void main(String[] args) {
    int x = 5;

    // boxing
    Integer i = Integer.valueOf(x);
    // unboxing
    int x2 = i.intValue();

    // autoboxing -> автоматически вызовется valueOf
    Integer i2 = 5;

    // autounboxing
    int x3 = i2;

  }
}
