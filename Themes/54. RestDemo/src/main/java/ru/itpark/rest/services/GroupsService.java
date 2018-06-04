package ru.itpark.rest.services;

import ru.itpark.rest.dto.GroupDto;
import ru.itpark.rest.dto.UserDto;

import java.util.List;

public interface GroupsService {
  List<GroupDto> getGroups();

  List<UserDto> getUsersOfGroup(Long groupId);
}
