package com.waterpls.waterpls.domain.entity;

import javax.persistence.Embeddable;

@Embeddable
public class NameEntity {

  private String name;

  public NameEntity() {

  }

  public NameEntity(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
