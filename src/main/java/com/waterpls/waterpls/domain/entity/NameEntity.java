package com.waterpls.waterpls.domain.entity;

import com.waterpls.waterpls.domain.value.NameVO;
import javax.persistence.Embeddable;

@Embeddable
public class NameEntity {

  private String name;

  public NameEntity() {

  }

  public NameEntity(String name) {
    this.name = name;
  }

  public NameEntity(NameVO nameVO) {
    name = nameVO.getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
