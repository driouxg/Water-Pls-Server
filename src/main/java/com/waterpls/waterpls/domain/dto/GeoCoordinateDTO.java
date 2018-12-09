package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoCoordinateDTO {
  private float coordinate;

  @JsonCreator
  public GeoCoordinateDTO(@JsonProperty("coordinate") float coordinate) {
    this.coordinate = coordinate;
  }

  public float getCoordinate() {
    return coordinate;
  }
}
