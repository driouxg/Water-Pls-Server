package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.dto.GeoCoordinateDTO;
import com.waterpls.waterpls.domain.entity.GeoCoordinateEntity;
import com.waterpls.waterpls.domain.validator.GeoCoordinateValidator;

public class GeoCoordinateVO extends ValueObject {

  private float coordinate;
  private GeoCoordinateValidator validator;

  public GeoCoordinateVO(float coordinate, GeoCoordinateValidator validator) {
    this.coordinate = coordinate;
    this.validator = validator;
    validate();
  }

  public GeoCoordinateVO(GeoCoordinateDTO coordinate, GeoCoordinateValidator validator) {
    this.coordinate = coordinate.getCoordinate();
    this.validator = validator;
  }

  public GeoCoordinateVO(GeoCoordinateEntity coordinateEntity, GeoCoordinateValidator validator) {
    this.coordinate = coordinateEntity.getCoordinate();
    this.validator = validator;
  }

  public float getCoordinate() {
    return coordinate;
  }

  private void validate() {
    validator.validateRange();
  }
}
