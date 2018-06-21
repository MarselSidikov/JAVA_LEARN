package ru.itpark.service.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  private UserDetailsService service;

  @Autowired
  private DataSource dataSource;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers(HttpMethod.GET, "/users")
          .hasAuthority("CAN_VIEW_USERS")
        .antMatchers(HttpMethod.POST, "/users")
          .permitAll()
        .antMatchers("/signUp")
          .permitAll()
        .antMatchers("/groups/**")
          .permitAll()
        .and()
          .formLogin()
          .loginPage("/login")
          .usernameParameter("login")
          .defaultSuccessUrl("/")
        .permitAll()
            .and()
            .rememberMe()
            .rememberMeParameter("remember-me")
            .tokenRepository(tokenRepository());

    http.csrf().disable();
  }

  @Bean
  public PersistentTokenRepository tokenRepository() {
    JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
    tokenRepository.setDataSource(dataSource);
    return tokenRepository;
  }

  @Autowired
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(service).passwordEncoder(passwordEncoder());
  }
}
