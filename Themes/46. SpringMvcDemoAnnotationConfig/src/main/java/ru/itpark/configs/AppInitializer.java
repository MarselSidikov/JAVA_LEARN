package ru.itpark.configs;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.itpark.filters.AuthenticationFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
    root.register(AppContext.class);

    servletContext.addListener(new ContextLoaderListener(root));

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(root));
    dispatcher.addMapping("/");
    dispatcher.setLoadOnStartup(1);

    servletContext.addFilter("authenticationFilter",
        new AuthenticationFilter()).addMappingForUrlPatterns(null, false,"/**");
  }


}
