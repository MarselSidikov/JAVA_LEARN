package ru.itpark;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

  public static <T extends Comparable<T>> void sort(T array[]) {
    for (int i = array.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j].compareTo(array[j + 1]) > 0) {
          T temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }


  public static void main(String[] args) {
    Human a = new Human("User", 27);
    Human b = new Human("User1", 10);
    Human d = new Human("User2", 23);
    Human c = new Human("User3", 17);
    Human x = new Human("User4", 5);

    Human humans[] = {a, b, c, d, x};

    Integer array[] = {3, 4, -1, -3, 4};

    sort(array);
    System.out.println(Arrays.toString(array));
    sort(humans);
    System.out.println(Arrays.toString(humans));
  }
}
