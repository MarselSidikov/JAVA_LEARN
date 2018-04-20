package ru.itpark;

public class LinkedList<T> implements List<T> {

  private Node top;
  private Node last;
  private int count;

  private class Node {
    T value;
    Node next;

    Node(T value) {
      this.value = value;
    }
  }

  @Override
  public T get(int index) {
    return null;
  }

  @Override
  public void delete(int index) {

  }

  @Override
  public void add(T element) {
    // создал узел для связного списка
    Node newNode = new Node(element);
//    Без last
//    if (top == null) {
//      top = newNode;
//    } else {
//      Node current = top;
//      while (current.next != null) {
//        current = current.next;
//      }
//
//      current.next = newNode;
//    }
    if (top == null) {
      top = newNode;
      last = newNode;
    } else {
      last.next = newNode;
      last = newNode;
    }
    count++;
  }

  @Override
  public boolean contains(T element) {
    return false;
  }

  @Override
  public int size() {
    return count;
  }

  @Override
  public boolean delete(T element) {
    return false;
  }
}
