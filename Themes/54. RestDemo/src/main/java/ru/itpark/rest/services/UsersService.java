package ru.itpark.rest.services;

import ru.itpark.rest.dto.GroupDto;
import ru.itpark.rest.dto.UserDto;

import java.util.List;

public interface UsersService {
  List<UserDto> getAllUsers();

  List<GroupDto> getGroupOfUser(Long userId);
}
