package com.waterpls.waterpls.controller;

import com.waterpls.waterpls.domain.value.DonaterVO;

public interface IDonatorController {

  void register(DonaterVO donator);

  void unregister();

  void search();
}
