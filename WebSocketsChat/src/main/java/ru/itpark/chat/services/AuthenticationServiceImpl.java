package ru.itpark.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.chat.models.User;
import ru.itpark.chat.repositories.UsersRepository;
import ru.itpark.chat.security.details.UserDetailsImpl;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return usersRepository.findOne(userDetails.getId());
    }
}
