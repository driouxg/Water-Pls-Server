package com.waterpls.waterpls.domain.entity;

import com.waterpls.waterpls.domain.value.GeoCoordinateVO;
import javax.persistence.Embeddable;

@Embeddable
public class GeoCoordinateEntity {

  private float coordinate;

  public GeoCoordinateEntity(float coordinate) {
    this.coordinate = coordinate;
  }

  public GeoCoordinateEntity() {

  }

  public GeoCoordinateEntity(GeoCoordinateVO geoCoordinateVO) {
    coordinate = geoCoordinateVO.getCoordinate();
  }

  public float getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(float coordinate) {
    this.coordinate = coordinate;
  }
}
