package ru.itpark.repositories;

import ru.itpark.models.User;

public interface UsersRepository extends CrudRepository<User> {
    User findOneByLogin(String login);
}
