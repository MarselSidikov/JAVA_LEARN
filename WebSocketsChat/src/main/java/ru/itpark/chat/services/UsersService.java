package ru.itpark.chat.services;

import ru.itpark.chat.forms.UserForm;
import ru.itpark.chat.transfer.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
    void addUser(UserForm user);
}
