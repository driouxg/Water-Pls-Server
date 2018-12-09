package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeographicLocationDTO {

  private GeoCoordinateDTO latitude;
  private GeoCoordinateDTO longitude;

  @JsonCreator
  public GeographicLocationDTO(@JsonProperty("latitude") GeoCoordinateDTO latitude,
      @JsonProperty("longitude") GeoCoordinateDTO longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoCoordinateDTO getLatitude() {
    return latitude;
  }

  public GeoCoordinateDTO getLongitude() {
    return longitude;
  }
}
