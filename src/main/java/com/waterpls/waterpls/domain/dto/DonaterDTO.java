package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DonaterDTO {

  private String firstName;
  private String lastName;
  private GeographicLocationDTO location;

  @JsonCreator
  public DonaterDTO(@JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("location") GeographicLocationDTO location) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public GeographicLocationDTO getLocation() {
    return location;
  }
}
