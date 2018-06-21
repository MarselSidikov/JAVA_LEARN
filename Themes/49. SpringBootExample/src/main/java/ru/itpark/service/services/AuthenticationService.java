package ru.itpark.service.services;

import org.springframework.security.core.Authentication;
import ru.itpark.service.dto.UserDto;

public interface AuthenticationService {
    UserDto getUserByAuthentication(Authentication authentication);
}
