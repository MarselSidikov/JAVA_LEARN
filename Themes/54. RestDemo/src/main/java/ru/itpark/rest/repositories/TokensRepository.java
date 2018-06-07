package ru.itpark.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.rest.models.Token;

import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token, Long> {
  Optional<Token> findOneByToken(String token);
}
