package com.waterpls.waterpls.resource;

import com.waterpls.waterpls.model.User;
import com.waterpls.waterpls.model.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

  @MessageMapping("/user")
  @SendTo("/topic/user")
  public UserResponse getUser(User user) {
    System.out.println("Reached User!");
    return new UserResponse("Hi " + user.getName());
  }

  @MessageMapping("/ping")
  public String ping(String string) {
    System.out.println("PING!!!!");
    return "wow";
  }

  @MessageMapping("/ping1")
  public String ping() {
    System.out.println("POOOOOOOOONG!!!");
    return "wow";
  }
}
