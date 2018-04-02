package ru.itpark;

import java.util.Arrays;

public class Main {

  public static void selectionSort(int array[]) {
    for (int i = 0; i < array.length; i++) {
      int currentMin = array[i];
      int indexOfCurrentMin = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < currentMin) {
          currentMin = array[j];
          indexOfCurrentMin = j;
        }
      }

      array[indexOfCurrentMin] = array[i];
      array[i] = currentMin;
    }
  }

  public static void main(String[] args) {
    int array[] = {31, 3, 12, -5, 12, 4, 5, -10, 15, 2};

    selectionSort(array);

//    {
//      int currentMin = array[0];
//      int indexOfCurrentMin = 0;
//      for (int i = 1; i < array.length; i++) {
//        if (array[i] < currentMin) {
//          currentMin = array[i];
//          indexOfCurrentMin = i;
//        }
//      }
//
//      array[indexOfCurrentMin] = array[0];
//      array[0] = currentMin;
//    }
//
//    {
//      int currentMin = array[1];
//      int indexOfCurrentMin = 1;
//      for (int i = 2; i < array.length; i++) {
//        if (array[i] < currentMin) {
//          currentMin = array[i];
//          indexOfCurrentMin = i;
//        }
//      }
//
//      array[indexOfCurrentMin] = array[1];
//      array[1] = currentMin;
//    }
//
//    {
//      int currentMin = array[2];
//      int indexOfCurrentMin = 2;
//      for (int i = 3; i < array.length; i++) {
//        if (array[i] < currentMin) {
//          currentMin = array[i];
//          indexOfCurrentMin = i;
//        }
//      }
//
//      array[indexOfCurrentMin] = array[2];
//      array[2] = currentMin;
//    }

    System.out.println(Arrays.toString(array));
  }
}
