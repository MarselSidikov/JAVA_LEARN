package ru.itpark;

public class Document {
  // поля/fields
  String name;
  String rows[];
  int count = 0;

  public Document(int numberOfRows) {
    rows = new String[numberOfRows];
  }

  public Document() {
    rows = new String[10];
  }

  void add(String row) {
    if (count < rows.length) {
      rows[count++] = row;
    } else System.err.println("Нет места");
  }

  void print() {
    System.out.println(name);
    for (int i = 0; i < rows.length; i++) {
      if (rows[i] != null) {
        System.out.println(rows[i]);
      } else {
        System.out.println("___________");
      }
    }
  }
}
