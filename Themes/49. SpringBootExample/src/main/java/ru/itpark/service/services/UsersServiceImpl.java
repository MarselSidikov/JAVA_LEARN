package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.service.dto.UserDto;
import ru.itpark.service.forms.UserForm;
import ru.itpark.service.models.User;
import ru.itpark.service.models.UserState;
import ru.itpark.service.repositories.UsersRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<UserDto> getAllUsers() {
    List<User> users = usersRepository.findAll();

    List<UserDto> userDtos = new ArrayList<>();
    for (User user : users) {
      userDtos.add(UserDto.builder()
          .id(user.getId())
          .login(user.getLogin())
          .state(user.getState().toString())
          .build());
    }
    return userDtos;
  }

  public void addUser(UserForm user) {
    String hashPassword = passwordEncoder.encode(user.getPassword());
    User newUser = User.builder()
        .login(user.getLogin())
        .name(user.getName())
        .hashPassword(hashPassword)
        .state(UserState.ACTIVE)
        .authorities(Collections.singletonList("CAN_VIEW_USERS"))
        .build();
    usersRepository.save(newUser);
  }

  @Override
  public UserDto changeStatus(Long userId) {
    User user = usersRepository.findOne(userId);
    if (user.getState().equals(UserState.ACTIVE)) {
      user.setState(UserState.BANNED);
    } else {
      user.setState(UserState.ACTIVE);
    }
    usersRepository.save(user);
    return UserDto.builder()
        .state(user.getState().toString())
        .build();
  }
}
