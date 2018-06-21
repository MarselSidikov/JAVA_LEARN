package ru.itpark.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.service.dto.UserDto;
import ru.itpark.service.models.User;
import ru.itpark.service.repositories.UsersRepository;
import ru.itpark.service.security.details.UserDetailsImpl;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDto getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = usersRepository.getOne(userDetails.getId());
        return UserDto.from(user);
    }
}
