package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DonaterDTO {

  private NameDTO firstName;
  private NameDTO lastName;
  private GeographicLocationDTO location;

  @JsonCreator
  public DonaterDTO(@JsonProperty("firstName") NameDTO firstName,
      @JsonProperty("lastName") NameDTO lastName,
      @JsonProperty("location") GeographicLocationDTO location) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  public NameDTO getFirstName() {
    return firstName;
  }

  public NameDTO getLastName() {
    return lastName;
  }

  public GeographicLocationDTO getLocation() {
    return location;
  }
}
