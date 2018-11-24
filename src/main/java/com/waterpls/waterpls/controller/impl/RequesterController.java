package com.waterpls.waterpls.controller.impl;

import com.waterpls.waterpls.controller.IRequesterController;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/requester")
public class RequesterController implements IRequesterController {

  @MessageMapping("/register")
  public void register() {

  }

  @MessageMapping("/unregister")
  public void unregister() {

  }

  @MessageMapping("/search")
  public void search() {

  }
}
