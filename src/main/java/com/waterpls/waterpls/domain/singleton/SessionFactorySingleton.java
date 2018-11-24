package com.waterpls.waterpls.domain.singleton;

import org.hibernate.SessionFactory;

public class SessionFactorySingleton {

  private static volatile SessionFactorySingleton instance;
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
