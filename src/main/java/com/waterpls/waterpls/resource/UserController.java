package com.waterpls.waterpls.resource;

import com.waterpls.waterpls.model.User;
import com.waterpls.waterpls.model.UserResponse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// https://spring.io/guides/gs/messaging-stomp-websocket/
@Controller
public class UserController {

  @Autowired
  SessionFactory sessionFactory;

  @MessageMapping("/user")
  @SendTo("/topic/user")
  public UserResponse getUser(User user) {
    System.out.println("Reached User!");


    // Try to use Hibernate to store items in the database



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
