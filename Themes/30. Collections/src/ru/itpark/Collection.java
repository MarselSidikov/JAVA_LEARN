package ru.itpark;

public interface Collection<T> {
  void add(T element);
  boolean contains(T element);
  int size();
  boolean delete(T element);
}
