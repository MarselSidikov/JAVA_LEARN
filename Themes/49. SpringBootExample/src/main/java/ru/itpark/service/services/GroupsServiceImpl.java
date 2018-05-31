package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.service.dto.GroupDto;
import ru.itpark.service.dto.UserDto;
import ru.itpark.service.models.Group;
import ru.itpark.service.models.User;
import ru.itpark.service.repositories.GroupsRepository;

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
