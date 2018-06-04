package ru.itpark.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itpark.rest.dto.GroupDto;
import ru.itpark.rest.dto.UserDto;
import ru.itpark.rest.models.User;
import ru.itpark.rest.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

  @Autowired
  private UsersRepository usersRepository;

//  @Autowired
//  private PasswordEncoder passwordEncoder;

  public List<UserDto> getAllUsers() {
    List<User> users = usersRepository.findAll();
    return UserDto.from(users);
  }

  @Override
  public List<GroupDto> getGroupOfUser(Long userId) {
    User user = usersRepository.findOne(userId);
    return GroupDto.from(user.getGroups());
  }
}
