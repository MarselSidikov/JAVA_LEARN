package ru.itpark;

public class MainPoly {
  public static void main(String[] args) {
    RealNumber rA = new RealNumber(3);
    RealNumber rB = new RealNumber(2);
    RealNumber rC = new RealNumber(5);
    RealNumber rD = new RealNumber(8);

    ComplexNumber cA = new ComplexNumber(3,4);
    ComplexNumber cB = new ComplexNumber(2,5);
    ComplexNumber cC = new ComplexNumber(11,2);
    ComplexNumber cD = new ComplexNumber(5,6);

    Quaternion quaternion = new Quaternion(1,2,3,4);

    RealNumber numbers[] = {rA, rB, rC, rD, cA, cB, cC, cD, quaternion};

    for (RealNumber number : numbers) {
      System.out.println(number.calcModule());
    }
  }
}
