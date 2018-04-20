package ru.itpark;

public interface Stack<T> extends Collection<T> {
  // положить в конец
  void push(T element);
  // забрать с конца
  T pop();
}
