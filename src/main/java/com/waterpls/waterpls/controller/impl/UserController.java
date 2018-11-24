package com.waterpls.waterpls.controller.impl;

import com.waterpls.waterpls.domain.User;
import com.waterpls.waterpls.domain.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// https://spring.io/guides/gs/messaging-stomp-websocket/
@Controller
public class UserController {

  @MessageMapping("/user")
  @SendTo("/topic/user")
  public UserResponse getUser(User user) {
    System.out.println("Reached User!");

    return new UserResponse("Hi " + user.getName());
  }

  @MessageMapping("/")
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
