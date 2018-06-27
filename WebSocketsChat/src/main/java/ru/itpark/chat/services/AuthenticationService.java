package ru.itpark.chat.services;

import org.springframework.security.core.Authentication;
import ru.itpark.chat.models.User;

public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}
