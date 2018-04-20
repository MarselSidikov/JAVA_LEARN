package ru.itpark;

public interface List<T> extends Collection<T> {
  T get(int index);
  void delete(int index);
}
