package com.waterpls.waterpls.service.impl;

import com.waterpls.waterpls.domain.dto.DonatorDTO;
import com.waterpls.waterpls.repository.IRepository;

public class LoginService {
  private IRepository repository;
  private DonatorDTO donatorDTO;

  public LoginService(IRepository repository, DonatorDTO donatorDTO) {
    this.repository = repository;
    this.donatorDTO = donatorDTO;
  }

  public boolean isCorrectPassword() {
    return false;
  }
}
