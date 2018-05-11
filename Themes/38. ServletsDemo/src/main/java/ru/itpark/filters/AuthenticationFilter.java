package ru.itpark.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Класс-фильтр, встречает запросы до того, как их
 * обработает сервлет
 * Фильтры могут образовывать цепочки, и каждый фильтр
 * может отдать запрос следующему фильтру
 * Чтобы класс действительно был фильтром, он должен
 * имплементировать интерфейс Filter
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // метод фильтрации, принимает на вход три параметра
    // запрос на сервлет
    // ответ на сервлет
    // цепочка фильтров
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // преобразуем запрос в HTTP
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        // если метод не требует аутентификации,
        // просто отдаем дальше по цепочке
        if (isNotSecured(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // если запрос требует безопасности
            // берем сессию пользователя (она
            // будет вытащена по Cookie JSSESIONID)
            HttpSession session = request.getSession(false);
            // если сессия есть и у нее есть атрибут authenticated
            if (session != null && session.getAttribute("authenticated") != null) {
                Boolean isAuthenticated = (Boolean)session.getAttribute("authenticated");
                if (isAuthenticated) {
                    // отправляем запрос дальше
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    ((HttpServletResponse)servletResponse).sendRedirect("/login");
                }
            } else {
                ((HttpServletResponse)servletResponse).sendRedirect("/login");
            }
        }
    }

    private boolean isNotSecured(HttpServletRequest request) {
        return isForLoginPage(request) ||
                isForPostSignUp(request) ||
                isForSignUpPage(request) ||
                isForCss(request);
    }

    private boolean isForCss(HttpServletRequest request) {
        return request.getMethod().equals("GET") &&
                request.getRequestURI().equals("/css/style.css");
    }
    private boolean isForLoginPage(HttpServletRequest request) {
        return ((request.getMethod().equals("GET") ||
                request.getMethod().equals("POST")))&& request.getRequestURI().equals("/login");
    }
    private boolean isForSignUpPage(HttpServletRequest request) {
        return request.getRequestURI().equals("/users") &&
                request.getMethod().equals("GET") &&
                request.getParameter("action") != null
                && request.getParameter("action").equals("signUp");
    }
    private boolean isForPostSignUp(HttpServletRequest request) {
        return request.getMethod().equals("POST") &&
                request.getRequestURI().equals("/users");
    }

    @Override
    public void destroy() {

    }
}
