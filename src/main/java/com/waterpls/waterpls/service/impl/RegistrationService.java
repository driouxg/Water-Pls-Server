package com.waterpls.waterpls.service.impl;

import com.waterpls.waterpls.domain.dto.DonatorDTO;
import com.waterpls.waterpls.domain.dto.RequesterDTO;
import com.waterpls.waterpls.domain.entity.DonatorEntity;
import com.waterpls.waterpls.domain.entity.RequesterEntity;
import com.waterpls.waterpls.repository.IRepository;
import com.waterpls.waterpls.service.IRegistrationService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationService implements IRegistrationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

  private IRepository repository;
  private DonatorDTO donaterDTO;
  private DonatorEntity donaterEntity;
  private RequesterEntity requesterEntity;
  private RequesterDTO requesterDTO;

  public RegistrationService(IRepository repository, DonatorDTO donaterDTO) {
    this.repository = repository;
    this.donaterDTO = donaterDTO;
    donaterEntity = convertDTOToEntity(donaterDTO, DonatorEntity.class);
  }

  public RegistrationService(IRepository repository, RequesterDTO requesterDTO) {
    this.repository = repository;
    this.requesterDTO = requesterDTO;
    requesterEntity = convertDTOToEntity(requesterDTO, RequesterEntity.class);
  }

  public void register() {
    if (!isAlreadyRegistered()) {
      repository.persist(donaterEntity);
    }
  }

  private List<DonatorEntity> query() {
    return repository.findObject(DonatorEntity.class, "username", donaterDTO.getUsername());
  }

  private boolean isAlreadyRegistered() {
    return query().size() > 0;
  }

  private <T> T convertDTOToEntity(Object dto, Class<T> clazz) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, clazz);
  }
}
