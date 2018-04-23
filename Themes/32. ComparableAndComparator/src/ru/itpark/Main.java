package ru.itpark;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

  // метод sort принимает на вход массив объектов любого произвольного типа T
  // заметим, что метод sort является параметризованным методом
  // внутри инструкции параметризации
  // стоит ограничитель extends Comparable
  // что метод может принимать только такие объекты типа T
  // которые являются сравниваемыми
  public static <T extends Comparable<T>> void sort(T array[]) {
    for (int i = array.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        // сравнивает два объекта
        // a[j] и a[j+1] через compareTo
        if (array[j].compareTo(array[j + 1]) > 0) {
          T temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  // данный метод принимает на вход помимо массива,
  // который не ограничен extends Comparable объект
  // типа Comparator, который позволит сравнить объекты
  public static <T> void sort(T array[], Comparator<T> comparator) {
    for (int i = array.length - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        // сравнивает два объекта
        // a[j] и a[j+1] через compareTo
        if (comparator.compare(array[j], array[j+1]) > 0) {
          T temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    Human a = new Human("Marsel", 24, 185);
    Human b = new Human("Artyom", 29, 165);
    Human d = new Human("Rustem", 27, 170);
    Human c = new Human("Shamil", 21, 185);
    Human x = new Human("Roman", 25, 175);

    Human humans[] = {a, b, c, d, x};

    Integer array[] = {3, 4, -1, -3, 4};

    sort(array);
    System.out.println(Arrays.toString(array));
    sort(humans);
    System.out.println(Arrays.toString(humans));
    sort(humans, new HumansByHeightComparator());
    System.out.println(Arrays.toString(humans));
  }
}
