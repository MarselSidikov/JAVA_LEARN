package ru.itpark;

public interface List extends Collection {
  Object get(int index);
  void delete(int index);
}
