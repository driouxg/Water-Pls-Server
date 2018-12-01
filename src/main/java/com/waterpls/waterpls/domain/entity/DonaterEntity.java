package com.waterpls.waterpls.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class DonaterEntity extends RootEntity {

  private String firstName;

  private String lastName;

  @OneToOne(cascade = CascadeType.ALL)
  private GeographicLocation location;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public GeographicLocation getLocation() {
    return location;
  }

  public void setLocation(GeographicLocation location) {
    this.location = location;
  }
}
