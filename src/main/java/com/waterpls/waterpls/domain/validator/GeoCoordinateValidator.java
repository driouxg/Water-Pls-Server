package com.waterpls.waterpls.domain.validator;

import com.waterpls.waterpls.domain.dto.GeoCoordinateDTO;
import com.waterpls.waterpls.domain.entity.GeoCoordinateEntity;
import com.waterpls.waterpls.domain.exception.GeoCoordinateException;

public class GeoCoordinateValidator {

  private float coordinate;

  public GeoCoordinateValidator(float coordinate) {
    this.coordinate = coordinate;
  }

  public GeoCoordinateValidator(GeoCoordinateEntity entity) {
    coordinate = entity.getCoordinate();
  }

  public GeoCoordinateValidator(GeoCoordinateDTO geoCoordinateDTO) {
    coordinate = geoCoordinateDTO.getCoordinate();
  }

  public void validateRange() {
    if (coordinate > 180f || coordinate < -180f) {
      throw new GeoCoordinateException(
          "Invalid value '" + coordinate + "': Must be in range [-180.0, 180.0]");
    }
  }
}
