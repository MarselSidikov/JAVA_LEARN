package ru.itpark;

public class RealNumber {
  protected double re;

  public RealNumber(double re) {
    this.re = re;
  }

  public double getRe() {
    return re;
  }

  public double calcModule() {
    return Math.abs(re);
  }
}
