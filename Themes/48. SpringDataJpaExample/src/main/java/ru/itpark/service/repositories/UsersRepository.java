package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.User;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
  List<User> findAllByAge(int age);
  List<User> findAllByNameContains(String part);

  @Query(nativeQuery = true, value = "SELECT * from service_user su WHERE su.age > ?1")
  List<User> findAllWhereAgeMoreThan(int age);
}
