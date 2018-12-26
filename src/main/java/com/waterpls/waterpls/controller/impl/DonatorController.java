package com.waterpls.waterpls.controller.impl;

import com.waterpls.waterpls.controller.IDonatorController;
import com.waterpls.waterpls.domain.UserResponse;
import com.waterpls.waterpls.domain.dto.DonatorDTO;
import com.waterpls.waterpls.domain.singleton.SessionFactorySingleton;
import com.waterpls.waterpls.repository.IRepository;
import com.waterpls.waterpls.repository.impl.HibernateRepository;
import com.waterpls.waterpls.service.impl.RegistrationService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/donator")
public class DonatorController implements IDonatorController {

  private IRepository repository;
  private SimpMessagingTemplate messagingTemplate;

  public DonatorController(SessionFactorySingleton sessionSingleton,
      SimpMessagingTemplate messagingTemplate) {
    this.repository = new HibernateRepository(sessionSingleton.getSessionFactory());
    this.messagingTemplate = messagingTemplate;
  }

  @MessageMapping("/register")
  public void register(DonatorDTO donater) {
    RegistrationService registrationService = new RegistrationService(repository, donater);
    registrationService.register();
  }

  @MessageMapping("/unregister")
  public void unregister() {

  }

  @MessageMapping("/search")
  public void search(String username) {
    System.out.println(username);
    messagingTemplate
        .convertAndSend("/secured/user/queue/specific-user", new UserResponse(username));

    messagingTemplate
        .convertAndSend("/secured/user/queue/specific-user", new UserResponse(username));

    messagingTemplate.convertAndSend("/secured/user/queue/specific-user-" + username,
        new UserResponse(username));

    messagingTemplate.convertAndSendToUser(username, "/user/"+username+"/queue", new UserResponse(username));

    messagingTemplate.convertAndSendToUser(username, "/secured/user/queue/specific-user",
        new UserResponse(username));

    messagingTemplate
        .convertAndSendToUser(username, "/queue/specific-user", new UserResponse(username));

    messagingTemplate.convertAndSend("/secured/user/queue/specific-user-" + username,
        new UserResponse(username));
  }

  @MessageExceptionHandler
  @SendToUser("/queue/errors")
  public String handleException(Throwable exception) {
    return exception.getMessage();
  }
}