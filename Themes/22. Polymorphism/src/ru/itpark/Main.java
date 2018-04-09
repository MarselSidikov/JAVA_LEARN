package ru.itpark;

public class Main {

  public static void main(String[] args) {
    RealNumber realNumber = new RealNumber(6);
    System.out.println(realNumber.calcModule());

    ComplexNumber complexNumber = new ComplexNumber(3, 4);
    System.out.println(complexNumber.calcModule());

    RealNumber a = complexNumber;
  }
}
