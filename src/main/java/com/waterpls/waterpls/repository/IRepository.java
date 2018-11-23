package com.waterpls.waterpls.repository;

import com.waterpls.waterpls.domain.entity.Username;

public interface IRepository {
  void commitUser(Username username);
}
