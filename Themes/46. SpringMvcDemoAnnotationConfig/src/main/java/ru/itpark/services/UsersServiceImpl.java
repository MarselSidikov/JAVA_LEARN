package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itpark.forms.UserForm;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

  private UsersRepository usersRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public UsersServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public List<User> getAllUsers() {
    return usersRepository.findAll();
  }

  @Override
  public void registerNewUser(UserForm userForm) {
    String hashPassword = passwordEncoder.encode(userForm.getPassword());
    User user = User.builder()
        .name(userForm.getName())
        .login(userForm.getLogin())
        .hashPassword(hashPassword)
        .build();
    usersRepository.save(user);
  }

  @Override
  public User login(UserForm userForm) {
    User userCandidate = usersRepository.findOneByLogin(userForm.getLogin());
    if (userCandidate == null) {
      return null;
    } else if (passwordEncoder.matches(userForm.getPassword(), userCandidate.getHashPassword())) {
      return userCandidate;
    } else return null;
  }

  @Autowired
  public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }
}
