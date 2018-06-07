package ru.itpark.rest.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itpark.rest.models.Token;
import ru.itpark.rest.repositories.TokensRepository;
import ru.itpark.rest.repositories.UsersRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private TokensRepository tokensRepository;

  @Transactional
  @Override
  public UserDetails loadUserByUsername(String tokenValue) throws UsernameNotFoundException {
    Optional<Token> candidateToken = tokensRepository.findOneByToken(tokenValue);
    if (candidateToken.isPresent()) {
      Token token = candidateToken.get();
      return new UserDetailsImpl(token.getUser());
    } else throw new BadCredentialsException("Not found token");
  }
}
