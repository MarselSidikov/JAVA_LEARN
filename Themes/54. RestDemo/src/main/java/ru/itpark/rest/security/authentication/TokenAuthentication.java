package ru.itpark.rest.security.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Класс, который описывает наш случай аутентификации - с токеном
 */
public class TokenAuthentication implements Authentication {
  // непосредственно сам токен
  private String token;

  // оба поля заполняются уже в провайдере
  // флаг - норм или не норм
  private boolean isAuthenticated;
  // непосредственно даныне пользователя
  private UserDetails userDetails;

  public TokenAuthentication(String token) {
    this.token = token;
  }

  public void setUserDetails(UserDetails userDetails) {
    this.userDetails = userDetails;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return userDetails.getAuthorities();
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getDetails() {
    return userDetails;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }

  @Override
  public boolean isAuthenticated() {
    return isAuthenticated;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    this.isAuthenticated = isAuthenticated;
  }

  @Override
  public String getName() {
    return token;
  }
}
