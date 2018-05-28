package ru.itpark.service.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.service.repositories.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//    Optional<User> candidate = usersRepository.findOneByLogin(username);
//    if (candidate.isPresent()) {
//      UserDetailsImpl userDetails = new
//          UserDetailsImpl(candidate.get());
//      return userDetails;
//    } else throw new BadCredentialsException("User not found");
    return new UserDetailsImpl(usersRepository.findOneByLogin(username).orElseThrow(() ->
        new BadCredentialsException("User not found")));
  }
}
