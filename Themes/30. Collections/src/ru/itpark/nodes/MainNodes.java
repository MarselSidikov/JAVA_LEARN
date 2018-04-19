package ru.itpark.nodes;

public class MainNodes {
  public static void main(String[] args) {
    Node a = new Node("Marsel");
    Node b = new Node("Ksusha");
    Node c = new Node("Artyom");
    Node d = new Node("Nastya");

    a.setNext(b);
    b.setNext(c);
    c.setNext(d);

    Node current = a;

    while (current != null) {
      System.out.println(current.getValue());
      current = current.getNext();
    }
    int i = 0;
  }
}
