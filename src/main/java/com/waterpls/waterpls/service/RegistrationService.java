package com.waterpls.waterpls.service;

import com.waterpls.waterpls.domain.dto.DonaterDTO;
import com.waterpls.waterpls.domain.entity.DonaterEntity;
import com.waterpls.waterpls.repository.IRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationService {

  private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

  private IRepository repository;
  private DonaterDTO donaterDTO;
  private DonaterEntity donaterEntity;

  public RegistrationService(IRepository repository, DonaterDTO donaterDTO) {
    LOGGER.info("Registering new Donator!");

    this.repository = repository;
    this.donaterDTO = donaterDTO;
    donaterEntity = convertDTOToEntity();

    donaterEntity.setId(1);
    System.out.println("Id: " + donaterEntity.getId());
    System.out.println("FirstName: " + donaterEntity.getFirstName());
    System.out.println("LastName: " + donaterEntity.getLastName());
    System.out.println("Latitude: " + donaterEntity.getLocation().getLatitude());
  }

  public void register() {
    if (!isAlreadyRegistered()) {
      repository.persist(donaterEntity);
    }
  }

  private boolean isAlreadyRegistered() {
    return false;
  }

  private DonaterEntity convertDTOToEntity() {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(donaterDTO, DonaterEntity.class);
  }
}
