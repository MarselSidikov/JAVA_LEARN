package ru.itpark;

public class Main {

  public static void main(String[] args) {
    int a[] = {3, 4, 6, 1};

    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }

    System.out.println();

    for (int i = a.length - 1; i >= 0; i--) {
      System.out.print(a[i] +" ");
    }


    System.out.println();
    for (int number : a) {
      System.out.print(number + " ");
    }
  }
}
