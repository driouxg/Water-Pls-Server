package com.waterpls.waterpls.controller.impl;

import com.waterpls.waterpls.controller.Donator;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/donator")
public class DonatorController implements Donator {

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