package ru.itpark.service.services;

import ru.itpark.service.forms.UserForm;

import java.util.List;

public interface UsersService {
  List<String> getAllNames();

  void addUser(UserForm user);
}
