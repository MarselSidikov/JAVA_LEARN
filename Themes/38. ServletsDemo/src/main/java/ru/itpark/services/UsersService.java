package ru.itpark.services;

import ru.itpark.forms.UserForm;
import ru.itpark.models.User;

import java.util.List;

public interface UsersService {
  List<User> getAllUsers();
  void registerNewUser(UserForm userForm);
  User login(UserForm userForm);
}
