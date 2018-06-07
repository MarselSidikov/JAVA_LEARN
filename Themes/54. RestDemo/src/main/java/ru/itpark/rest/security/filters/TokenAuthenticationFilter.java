package ru.itpark.rest.security.filters;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.itpark.rest.security.authentication.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Фильтр, принимает запрос, конвертирует его в объект
 * аутентифкации и отдает контексту
 */
@Component
public class TokenAuthenticationFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    // получили http-запрос
    HttpServletRequest request = (HttpServletRequest)servletRequest;
    // вытащили токен
    String token = request.getParameter("token");
    // если токен не пустой
    if (token != null) {
      // создаем объект аутентификации
      TokenAuthentication authentication = new TokenAuthentication(token);
      // отдаем объект контексту
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    // отправляем запрос дальше по фильтрам, если они есть.
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {

  }
}
