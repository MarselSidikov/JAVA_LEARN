package ru.itpark.unit;

public class Main {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    System.out.println(calculator.sum(5, 6));
    System.out.println(calculator.isPrimary(6));
    System.out.println(calculator.isPrimary(7));
    System.out.println(calculator.isPrimary(9));
//    System.out.println(calculator.isPrimary(0));
//    System.out.println(calculator.isPrimary(1));
  }
}
