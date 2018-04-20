package ru.itpark.repository;

import java.util.List;

public interface CrudRepository<T> {
  void save(T model);
  void delete(int id);
  void update(T model);
  T find(int id);
  List<T> findAll();
}
