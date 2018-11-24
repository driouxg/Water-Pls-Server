package com.waterpls.waterpls.repository;

import com.waterpls.waterpls.repository.exception.DataAccessLayerException;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class CloseableTransaction implements AutoCloseable {

  private Transaction tx;

  public CloseableTransaction(Transaction tx) {
    this.tx = tx;
  }

  public Transaction getTransaction() {
    return tx;
  }

  @Override
  public void close() {
    try {
      tx.commit();
    } catch (HibernateException e) {
      tx.rollback();
      throw new DataAccessLayerException(e);
    }
  }
}
