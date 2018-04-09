package ru.itpark;

public class Main {

  public static void main(String[] args) {
    String s1 = "Hello";
    String s2 = "Hello";

    String s4 = new String("Hello");
    String s5 = new String("Hello");

    System.out.println(s1 == s2);
    System.out.println(s4 == s5);
    System.out.println(s4.equals(s5));

    s1 = s1.concat("Bye");
    System.out.println(s1);
    System.out.println(s2);
  }
}
