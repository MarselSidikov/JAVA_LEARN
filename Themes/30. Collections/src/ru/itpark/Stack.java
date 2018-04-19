package ru.itpark;

public interface Stack extends Collection {
  // положить в конец
  void push(Object element);
  // забрать с конца
  Object pop();
}
