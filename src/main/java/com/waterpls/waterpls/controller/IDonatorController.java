package com.waterpls.waterpls.controller;

import com.waterpls.waterpls.domain.dto.DonatorDTO;
import java.security.Principal;

public interface IDonatorController {

  void register(DonatorDTO donator);

  void unregister();

  void search(String username);
}
