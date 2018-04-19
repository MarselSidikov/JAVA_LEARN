package ru.itpark;

public interface Collection {
  void add(Object element);
  boolean contains(Object element);
  int size();
  boolean delete(Object element);
}
