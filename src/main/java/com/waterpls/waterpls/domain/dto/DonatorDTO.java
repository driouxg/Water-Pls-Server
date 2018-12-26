package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DonatorDTO {

  private UsernameDTO username;
  private PasswordDTO password;
  private NameDTO firstName;
  private NameDTO lastName;
  private GeographicLocationDTO location;

  @JsonCreator
  public DonatorDTO(@JsonProperty("username") UsernameDTO username,
      @JsonProperty("password") PasswordDTO password, @JsonProperty("firstName") NameDTO firstName,
      @JsonProperty("lastName") NameDTO lastName,
      @JsonProperty("location") GeographicLocationDTO location) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  public UsernameDTO getUsername() {
    return username;
  }

  public PasswordDTO getPassword() {
    return password;
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
