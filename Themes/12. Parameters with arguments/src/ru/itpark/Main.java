package ru.itpark;

import java.util.Arrays;

public class Main {

  public static void swap(int array[], int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
  }

  public static void main(String[] args) {
    int x = 10;
    int y = 20;
    swap(x, y);

    System.out.println(x);
    System.out.println(y);

    int myArray[] = {1, 2, 3, 4, 5};
    swap(myArray, 2, 3);
    System.out.println(Arrays.toString(myArray));
  }
}
