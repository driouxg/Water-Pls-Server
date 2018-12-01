package com.waterpls.waterpls.service;

import com.waterpls.waterpls.domain.dto.DonaterDTO;
import com.waterpls.waterpls.domain.dto.RequesterDTO;
import com.waterpls.waterpls.domain.entity.DonaterEntity;
import com.waterpls.waterpls.domain.entity.RequesterEntity;
import com.waterpls.waterpls.repository.IRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

  private IRepository repository;
  private DonaterDTO donaterDTO;
  private DonaterEntity donaterEntity;
  private RequesterEntity requesterEntity;
  private RequesterDTO requesterDTO;

  public RegistrationService(IRepository repository, DonaterDTO donaterDTO) {
    this.repository = repository;
    this.donaterDTO = donaterDTO;
    donaterEntity = convertDTOToEntity(DonaterEntity.class, donaterDTO);
  }

  public RegistrationService(IRepository repository, RequesterDTO requesterDTO) {
    this.repository = repository;
    this.requesterDTO = requesterDTO;
    requesterEntity = convertDTOToEntity(RequesterEntity.class, requesterDTO);
  }

  public void register() {
    if (!isAlreadyRegistered()) {
      repository.persist(donaterEntity);
    }
  }

  private boolean isAlreadyRegistered() {
    return false;
  }

  private <T> T convertDTOToEntity(Class<T> clazz, Object dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, clazz);
  }
}
