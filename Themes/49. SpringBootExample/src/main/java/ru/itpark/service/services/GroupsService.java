package ru.itpark.service.services;

import ru.itpark.service.dto.GroupDto;
import ru.itpark.service.dto.UserDto;

import java.util.List;

public interface GroupsService {
  List<GroupDto> getGroups();

  List<UserDto> getUsersOfGroup(Long groupId);
}
