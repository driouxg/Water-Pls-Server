package com.waterpls.waterpls.model.entity;

import javax.persistence.Id;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
public class Username {

  @Id
  private Integer id;

  private String username;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
