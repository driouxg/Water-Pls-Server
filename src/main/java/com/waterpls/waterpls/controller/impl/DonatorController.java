package com.waterpls.waterpls.controller.impl;

import com.waterpls.waterpls.controller.IDonatorController;
import com.waterpls.waterpls.domain.dto.DonaterDTO;
import com.waterpls.waterpls.domain.singleton.SessionFactorySingleton;
import com.waterpls.waterpls.repository.IRepository;
import com.waterpls.waterpls.repository.impl.HibernateRepository;
import com.waterpls.waterpls.service.RegistrationService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/donater")
public class DonatorController implements IDonatorController {

  private IRepository repository;

  public DonatorController() {
    SessionFactorySingleton sessionFactorySingleton = SessionFactorySingleton.getInstance();
    this.repository = new HibernateRepository(sessionFactorySingleton.getSessionFactory());
  }

  @MessageMapping("/register")
  public void register(DonaterDTO donater) {
    RegistrationService registrationService = new RegistrationService(repository, donater);
    registrationService.register();
  }

  @MessageMapping("/unregister")
  public void unregister() {

  }

  @MessageMapping("/search")
  public void search() {

  }
}