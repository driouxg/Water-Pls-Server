package com.waterpls.waterpls.repository.impl;

import com.waterpls.waterpls.repository.CloseableSession;
import com.waterpls.waterpls.repository.CloseableTransaction;
import com.waterpls.waterpls.repository.IRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateRepository implements IRepository {

  private SessionFactory sessionFactory;

  public HibernateRepository(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void persist(Object o) {
    try (CloseableSession session = createCloseableSession();
        CloseableTransaction transaction = createCloseableTransaction(session)) {
      session.getSession().persist(o);
    }
  }

  public <T> List<T> getAll(Class<T> type) {
    try (CloseableSession session = createCloseableSession();
        CloseableTransaction transaction = createCloseableTransaction(session)) {

      CriteriaBuilder builder = session.getSession().getCriteriaBuilder();

      CriteriaQuery<T> query = builder.createQuery(type);

      Root<T> root = query.from(type);

      query.select(root);

      Query<T> q = session.getSession().createQuery(query);

      return q.getResultList();
    }
  }

  @SuppressWarnings("unchecked")
  public <T> T merge(T o) {
    try (CloseableSession session = createCloseableSession();
        CloseableTransaction transaction = createCloseableTransaction(session)) {
      return (T) session.getSession().merge(o);
    }
  }

  public <T> void saveOrUpdate(T o) {
    try (CloseableSession session = createCloseableSession();
        CloseableTransaction transaction = createCloseableTransaction(session)) {
      session.getSession().saveOrUpdate(o);
    }
  }

  public void delete(Object o) {
    try (CloseableSession session = createCloseableSession();
        CloseableTransaction transaction = createCloseableTransaction(session)) {
      session.getSession().delete(o);
    }
  }

  public <T> T get(Class<T> type, long id) {
    try (CloseableSession session = createCloseableSession()) {
      Transaction transaction = session.getSession().beginTransaction();
      return session.getSession().get(type, id);
    }
  }

  private CloseableSession createCloseableSession() {
    return new CloseableSession(sessionFactory.openSession());
  }

  private CloseableTransaction createCloseableTransaction(CloseableSession session) {
    return new CloseableTransaction(session.getSession().beginTransaction());
  }
}
