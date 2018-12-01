package com.waterpls.waterpls.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository {

  void persist(Object o);

  void save(Object o);

  <T> T merge(final T o);

  <T> void saveOrUpdate(final T o);

  void delete(final Object o);

  <T> T get(final Class<T> type, final long id);

  <T> List<T> getAll(final Class<T> type);
}
