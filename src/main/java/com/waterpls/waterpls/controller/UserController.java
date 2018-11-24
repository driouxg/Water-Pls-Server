package com.waterpls.waterpls.controller;

import com.waterpls.waterpls.domain.User;
import com.waterpls.waterpls.domain.UserResponse;
import com.waterpls.waterpls.domain.entity.Username;
import com.waterpls.waterpls.repository.IRepository;
import com.waterpls.waterpls.repository.impl.HibernateRepository;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// https://spring.io/guides/gs/messaging-stomp-websocket/
@Controller
public class UserController {

  //@Autowired
  SessionFactory sessionFactory;

  //@Autowired
  private IRepository repository;

  public UserController(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
    this.repository = new HibernateRepository(sessionFactory);
  }

  @MessageMapping("/user")
  @SendTo("/topic/user")
  public UserResponse getUser(User user) {
    System.out.println("Reached User!");

    Username username = new Username();
    username.setId(1);
    username.setUsername("DryOx");

    List<Username> list = repository.getAll(Username.class);

    System.out.println("PRINTING " + list.size() + " USERNAMES FROM DATABASE!");
    for (Username l : list) {
      System.out.println("" + l.getUsername());
    }

    return new UserResponse("Hi " + user.getName());
  }

  @MessageMapping("/ping")
  public String ping(String string) {
    System.out.println("PING!!!!");
    return "wow";
  }

  @MessageMapping("/ping1")
  @SendTo("/the/pinger")
  public String ping() {
    System.out.println("POOOOOOOOONG!!!");
    return "wow";
  }
}
