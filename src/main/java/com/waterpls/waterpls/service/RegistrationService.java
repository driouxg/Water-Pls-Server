package com.waterpls.waterpls.service;

import com.waterpls.waterpls.domain.value.DonaterVO;
import com.waterpls.waterpls.repository.IRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

  private IRepository repository;
  private DonaterVO donator;

  public RegistrationService(IRepository repository, DonaterVO donater) {
    LOGGER.info("Registering new Donator!");
    if(donater == null) {
      LOGGER.error("Donator is null :(");
    } else {
      LOGGER.info("Donator is not null :D");
    }

    this.repository = repository;
    this.donator = donater;
  }

  public void register() {
    if (!isAlreadyRegistered()) {
      repository.persist(donator);
    }
  }

  private boolean isAlreadyRegistered() {
    return false;
  }
}
