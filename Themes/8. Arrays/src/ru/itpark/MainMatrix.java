package ru.itpark;

import java.util.Random;

public class MainMatrix {
  public static void main(String[] args) {
//    int matrixA[][] = new int[5][6];
//
//    for (int i = 0; i < matrixA.length; i++) {
//      for (int j = 0; j < matrixA[0].length; j++) {
//        System.out.print(matrixA[i][j] + " ");
//      }
//      System.out.println();
//    }

//    int a[][] = new int[5][];
//    Random random = new Random();
//    for (int i = 0; i < 5; i++) {
//      a[i] = new int[random.nextInt(10)];
//    }
//
//    for (int i = 0; i < a.length; i++) {
//      for (int j = 0; j < a[i].length; j++) {
//        System.out.print(a[i][j] + " ");
//      }
//      System.out.println();
//    }

    int matrix[][] = {
        {2, 3, 4},
        {5, 6, 2},
        {1, 2, 3}
    };

//    for (int i = 0; i < matrix.length; i++) {
//      System.out.print(matrix[i][i] + " ");
//    }

    for (int row[] : matrix) {
      for (int element : row) {
        System.out.print(element + " ");
      }
      System.out.println();
    }
  }
}
