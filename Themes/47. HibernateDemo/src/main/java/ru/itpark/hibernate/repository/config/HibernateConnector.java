package ru.itpark.hibernate.repository.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnector {
  private static HibernateConnector connector;

  private SessionFactory sessionFactory;

  private HibernateConnector() {
    sessionFactory =
        new Configuration()
            .configure("ru.itpark/hibernate.cfg.xml")
            .buildSessionFactory();
  }

  static {
    connector = new HibernateConnector();
  }

  public static HibernateConnector getConnector() {
    return connector;
  }

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
