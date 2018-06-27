package ru.itpark.chat.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itpark.chat.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

  private String login;
  private String hashPassword;
  private Long id;
  private List<SimpleGrantedAuthority> authorities;

  public UserDetailsImpl(User user) {
    this.login = user.getLogin();
    this.hashPassword = user.getHashPassword();
    this.id = user.getId();
    this.authorities = new ArrayList<>();
    for (String stringAuthority : user.getAuthorities()) {
      this.authorities.add(new SimpleGrantedAuthority(stringAuthority));
    }
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.hashPassword;
  }

  @Override
  public String getUsername() {
    return this.login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public Long getId() {
    return id;
  }
}
