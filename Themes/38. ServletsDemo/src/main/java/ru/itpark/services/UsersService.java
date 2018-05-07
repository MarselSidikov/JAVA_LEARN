package ru.itpark.services;

import ru.itpark.models.User;

import java.util.List;

public interface UsersService {
  List<User>  findAllUsersFromDataBase();
}
