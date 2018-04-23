package ru.itpark;

import java.util.Iterator;

public class MainArrayListIterator {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("Marsel");
    list.add("Shamil");
    list.add("Roman");
    list.add("Adel");
    list.add("Rustem");
    list.add("Sergey");
    list.add("Damir");
    list.add("Nastya");
    list.add("Egor");
    list.add("Ilya");
    list.add("Marsel");
    list.add("Nailya");

//    Iterator<String> iterator = list.iterator();
//
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
//    }

    for (String string : list) {
      System.out.println(string);
    }
  }
}
