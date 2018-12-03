package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.entity.GeographicLocationEntity;

public class DonaterVO extends ValueObject {

  private String firstName;
  private String lastName;
  private GeographicLocationEntity location;

  public DonaterVO(String firstName, String lastName,
      GeographicLocationEntity location) {
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

  public GeographicLocationEntity getLocation() {
    return location;
  }
}
