package ru.itpark;

public class Quaternion extends ComplexNumber {
  private double im2;
  private double im3;

  public Quaternion(double re, double im, double im2, double im3) {
    super(re, im);
    this.im2 = im2;
    this.im3 = im3;
  }

  public double calcModule() {
    return Math.sqrt(re * re + im * im + im2 * im2 + im3 * im3);
  }
}
