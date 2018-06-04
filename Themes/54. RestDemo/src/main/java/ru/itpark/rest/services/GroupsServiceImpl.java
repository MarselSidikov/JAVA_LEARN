package ru.itpark.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.rest.dto.GroupDto;
import ru.itpark.rest.dto.UserDto;
import ru.itpark.rest.models.Group;
import ru.itpark.rest.repositories.GroupsRepository;

import java.util.List;

@Component
public class GroupsServiceImpl implements GroupsService {

  @Autowired
  private GroupsRepository groupsRepository;

  @Override
  public List<GroupDto> getGroups() {
    return GroupDto.from(groupsRepository.findAll());
  }

  @Override
  public List<UserDto> getUsersOfGroup(Long groupId) {
    Group group = groupsRepository.getOne(groupId);
    return UserDto.from(group.getUsers());
  }
}
