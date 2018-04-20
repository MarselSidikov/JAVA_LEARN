package ru.itpark;

public class MainWithoutGenerics {
  public static void main(String[] args) {
    List stringsList = new ArrayList();
    stringsList.add("Marsel");
    stringsList.add("Vanya");
    stringsList.add("Petya");

    String valueFromList = (String)stringsList.get(0);
    System.out.println(valueFromList);

    List integersList = new ArrayList();
    integersList.add(2);
    integersList.add(5);
    integersList.add(6);

    int valueFromIntegerList = (int)integersList.get(2);
    System.out.println(valueFromIntegerList);

    List list = new ArrayList();
    list.add("Hello!");
    list.add(5);

    String v1  = (String) list.get(1);
    int v2 = (int)list.get(0);
    System.out.println(v1 + " " + v2);
  }
}
