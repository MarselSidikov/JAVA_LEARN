package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.service.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
  List<User> findAllByAge(int age);
  List<User> findAllByNameContains(String part);

  Optional<User> findOneByLogin(String login);

  @Query(nativeQuery = true, value = "SELECT * from service_user su WHERE su.age > ?1")
  List<User> findAllWhereAgeMoreThan(int age);
}
