package ru.itpark.service.services;

import ru.itpark.service.dto.UserDto;
import ru.itpark.service.forms.UserForm;

import java.util.List;

public interface UsersService {
  List<UserDto> getAllUsers();

  void addUser(UserForm user);

  UserDto changeStatus(Long userId);
}
