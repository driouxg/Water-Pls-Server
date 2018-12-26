package com.waterpls.waterpls.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.waterpls.waterpls.domain.value.GeoCoordinateVO;
import javax.persistence.Embeddable;

@Embeddable
public class GeoCoordinateDTO {
  private float coordinate;

  public GeoCoordinateDTO() {
  }

  public GeoCoordinateDTO(GeoCoordinateVO geoCoordinateVO) {
    coordinate = geoCoordinateVO.getCoordinate();
  }

  @JsonCreator
  public GeoCoordinateDTO(@JsonProperty("coordinate") float coordinate) {
    this.coordinate = coordinate;
  }

  public float getCoordinate() {
    return coordinate;
  }
}
