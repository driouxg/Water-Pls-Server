package com.waterpls.waterpls.controller;

import com.waterpls.waterpls.domain.dto.RequesterDTO;

public interface IRequesterController {

  void register(RequesterDTO requester);

  void unregister();

  void search();
}
