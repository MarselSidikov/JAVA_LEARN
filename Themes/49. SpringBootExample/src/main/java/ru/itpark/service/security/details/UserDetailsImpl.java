package ru.itpark.service.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itpark.service.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

  private String login;
  private String hashPassword;
  private String state;
  private Long id;
  private List<SimpleGrantedAuthority> authorities;

  public UserDetailsImpl(User user) {
    this.login = user.getLogin();
    this.hashPassword = user.getHashPassword();
    this.state = user.getState().toString();
    this.id = user.getId();
    this.authorities = new ArrayList<SimpleGrantedAuthority>();
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
    return !state.equals("BANNED");
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return this.state.equals("ACTIVE");
  }

  public Long getId() {
    return id;
  }
}
