package ru.itpark.chat.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.chat.forms.UserForm;
import ru.itpark.chat.models.User;
import ru.itpark.chat.repositories.UsersRepository;
import ru.itpark.chat.transfer.UserDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.itpark.chat.transfer.UserDto.from;


@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }

    public void addUser(UserForm user) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        User newUser = User.builder()
                .login(user.getLogin())
                .name(user.getName())
                .hashPassword(hashPassword)
                .authorities(Arrays.asList("CAN_CREATE_CHAT", "CAN_SEND_AND_GET_MESSAGES"))
                .build();
        usersRepository.save(newUser);
    }

}
