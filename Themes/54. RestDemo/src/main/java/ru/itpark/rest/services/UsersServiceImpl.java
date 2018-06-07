package ru.itpark.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.rest.dto.GroupDto;
import ru.itpark.rest.dto.TokenDto;
import ru.itpark.rest.dto.UserDto;
import ru.itpark.rest.forms.LoginPasswordForm;
import ru.itpark.rest.models.Token;
import ru.itpark.rest.models.User;
import ru.itpark.rest.repositories.TokensRepository;
import ru.itpark.rest.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UsersServiceImpl implements UsersService {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private TokensRepository tokensRepository;

  public List<UserDto> getAllUsers() {
    List<User> users = usersRepository.findAll();
    return UserDto.from(users);
  }

  @Override
  public List<GroupDto> getGroupOfUser(Long userId) {
    User user = usersRepository.findOne(userId);
    return GroupDto.from(user.getGroups());
  }

  @Override
  public TokenDto login(LoginPasswordForm form) {
    Optional<User> candidateUser = usersRepository.findOneByLogin(form.getLogin());
      if (candidateUser.isPresent()) {
        User user = candidateUser.get();
        if (passwordEncoder.matches(form.getPassword(), user.getHashPassword())) {
          String tokenValue = UUID.randomUUID().toString();
          Token token = Token.builder()
              .token(tokenValue)
              .user(user)
              .build();
          tokensRepository.save(token);
          return new TokenDto(token.getToken());
        } else throw new BadCredentialsException("Login or password is invalid");
      } else throw new BadCredentialsException("Login or password is invalid");
    }
}
