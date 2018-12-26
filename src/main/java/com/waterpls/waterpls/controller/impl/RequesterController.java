package com.waterpls.waterpls.controller.impl;

import com.waterpls.waterpls.controller.IRequesterController;
import com.waterpls.waterpls.domain.dto.RequesterDTO;
import com.waterpls.waterpls.domain.entity.DonatorEntity;
import com.waterpls.waterpls.domain.singleton.SessionFactorySingleton;
import com.waterpls.waterpls.repository.IRepository;
import com.waterpls.waterpls.repository.impl.HibernateRepository;
import com.waterpls.waterpls.service.impl.RegistrationService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/requester")
public class RequesterController implements IRequesterController {

  private IRepository repository;

  public RequesterController(SessionFactorySingleton sessionFactorySingleton) {
    this.repository = new HibernateRepository(sessionFactorySingleton.getSessionFactory());
  }

  @MessageMapping("/register")
  public void register(RequesterDTO requester) {
    RegistrationService registrationService = new RegistrationService(repository, requester);
    registrationService.register();
  }

  @MessageMapping("/unregister")
  public void unregister() {

  }

  @MessageMapping("/search")
  public void search() {
    repository.getAll(DonatorEntity.class);
  }
}
