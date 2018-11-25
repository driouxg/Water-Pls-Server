package com.waterpls.waterpls.controller;

import com.waterpls.waterpls.domain.dto.DonaterDTO;

public interface IDonatorController {

  void register(DonaterDTO donator);

  void unregister();

  void search();
}
