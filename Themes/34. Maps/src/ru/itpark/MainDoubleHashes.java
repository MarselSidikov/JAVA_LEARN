package ru.itpark;

public class MainDoubleHashes {
  public static void main(String[] args) {
    Double d1 = 0.01;
    Double d2 = 0.02;
    Double d3 = 0.03;
    Double d4 = 0.04;

    System.out.println(d1.hashCode());
    System.out.println(d2.hashCode());
    System.out.println(d3.hashCode());
    System.out.println(d4.hashCode());

  }
}
