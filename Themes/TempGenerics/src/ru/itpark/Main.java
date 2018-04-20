package ru.itpark;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> stringsArrayList = new ArrayList<>();
    stringsArrayList.add("Marsel");
    stringsArrayList.add("Aryom");
    stringsArrayList.add("Ksusha");

    String v1 = stringsArrayList.get(0);
    System.out.println(v1);

    ArrayList<Integer> integerArrayList = new ArrayList<>();
    integerArrayList.add(123);
    integerArrayList.add("Hello");
  }
}
