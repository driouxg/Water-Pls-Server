package com.waterpls.waterpls.domain.singleton;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionFactorySingleton {

  private static volatile SessionFactorySingleton instance;
  @Autowired
  private SessionFactory sessionFactory;

  private SessionFactorySingleton() {
  }

  public static SessionFactorySingleton getInstance() {
    if (instance == null) {
      synchronized (SessionFactorySingleton.class) {
        if (instance == null) {
          instance = new SessionFactorySingleton();
        }
      }
    }
    return instance;
  }

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
