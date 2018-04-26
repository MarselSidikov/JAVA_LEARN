package ru.itpark;

public class Main {

  public static void main(String[] args) {
    char array[] = "abcef".toCharArray();
    int hashCode = 0;
    for (int i = 0; i < array.length; i++) {
      hashCode = hashCode + array[i] * i;
      System.out.println((int)array[i]);
    }
    System.out.println(hashCode);

    int hash = "abcef".hashCode();
    System.out.println(hash);
  }
}
