package ru.itpark;

public class ComplexNumber extends RealNumber {
  protected double im;

  public ComplexNumber(double re, double im) {
    super(re);
    this.im = im;
  }

  @Override
  public double calcModule() {
    return Math.sqrt(re * re + im * im);
  }
}
