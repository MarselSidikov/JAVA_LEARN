package ru.itpark.service.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{AppContext.class};
  }

  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{AppContext.class};
  }

  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
