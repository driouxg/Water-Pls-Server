package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Embeddable;

@Embeddable
public class NameDTO {

  private String name;

  public NameDTO() {
  }

  @JsonCreator
  public NameDTO(@JsonProperty("name") String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
