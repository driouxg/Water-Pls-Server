package com.waterpls.waterpls.repository;

import org.hibernate.Session;

public class CloseableSession implements AutoCloseable {

  private Session session;

  public CloseableSession(Session session) {
    this.session = session;
  }

  public Session getSession() {
    return session;
  }

  @Override
  public void close() {
    session.close();
  }
}
