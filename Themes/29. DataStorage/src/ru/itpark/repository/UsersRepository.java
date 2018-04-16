package ru.itpark.repository;

import ru.itpark.models.User;

public interface UsersRepository {
  User find(int id);
  void delete(int id);
  void save(User user);

  /**
   * Пусть в файле есть запись
   * 3 1994-02-02 Марсель Сидиков
   *
   * Если объект user имеет вид
   * 3 1994-02-02 Сергей Руденко
   *
   * то после update в файле должен быть Руденко
   * @param user
   */
  void update(User user);

  // User[] findAll();
}
