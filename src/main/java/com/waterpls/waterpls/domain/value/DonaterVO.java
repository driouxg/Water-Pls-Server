package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.entity.GeographicLocation;

public class DonaterVO extends ValueObject {

  private String firstName;
  private String lastName;
  private GeographicLocation location;

  public DonaterVO(String firstName, String lastName,
      GeographicLocation location) {
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

  public GeographicLocation getLocation() {
    return location;
  }
}
