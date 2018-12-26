package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Embeddable;

@Embeddable
public class PasswordDTO {

  private String password;

  public PasswordDTO() {
  }

  @JsonCreator
  public PasswordDTO(@JsonProperty("password") String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
