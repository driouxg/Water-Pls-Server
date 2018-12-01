package com.waterpls.waterpls.domain.entity;

import javax.persistence.Entity;

@Entity
public class GeographicLocation extends RootEntity {

  private String latitude;
  private String longitude;

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }
}
