package ru.itpark.rest.security.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.itpark.rest.security.authentication.TokenAuthentication;

/**
 * Компонент, который занимается непосредственной обработкой
 * объекта аутентификации
 */
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {
  // специальный сервис, который
  // позволяет получить данные пользователя
  // по его токену
  @Autowired
  private UserDetailsService service;

  // метод, который непосредственно аутентифицирует клиента
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    // преобразуем входной объект аутентификации
    // в Токен-аутентификацию
    TokenAuthentication tokenAuthentication = (TokenAuthentication)authentication;
    // загружаем данные пользователя
    // если данные загрузить не удалось
    // будет выброшена ошибка
    UserDetails userDetails = service.loadUserByUsername(tokenAuthentication.getName());
    // данные подставляем в объект аутентификации
    tokenAuthentication.setUserDetails(userDetails);
    // говорим, что пользователь норм
    tokenAuthentication.setAuthenticated(true);
    // отдаем обратно контексту
    return tokenAuthentication;
  }
  // указываем, что наш класс-провайдер поддерживает
  // TokenAuthentication
  @Override
  public boolean supports(Class<?> authentication) {
    return TokenAuthentication.class.isAssignableFrom(authentication);
  }
}
