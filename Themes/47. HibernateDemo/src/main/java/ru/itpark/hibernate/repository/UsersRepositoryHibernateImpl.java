package ru.itpark.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.itpark.hibernate.demo.models.User;
import java.util.List;

public class UsersRepositoryHibernateImpl {
  private SessionFactory sessionFactory;
  private Session session;

  public UsersRepositoryHibernateImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
    this.session = openSession();
  }

  public List<User> findAll() {
    Session session = openSession();
    Query<User> userQuery = session.createQuery("from User", User.class);
    return userQuery.getResultList();
  }

  private Session openSession() {
    if (session != null && session.isOpen()) {
      return session;
    } else {
      return sessionFactory.openSession();
    }
  }
}
