package ru.itpark.repositories;

import java.util.List;

public interface CrudRepository<T> {
  T find(int id);
  List<T> findAll();
  void save(T model);
}
