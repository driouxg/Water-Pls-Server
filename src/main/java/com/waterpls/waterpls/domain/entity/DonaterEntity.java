package com.waterpls.waterpls.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DonaterEntity {

  @Id
  private Integer id;

  private String firstName;

  private String lastName;

  private GeographicLocation location;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

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
