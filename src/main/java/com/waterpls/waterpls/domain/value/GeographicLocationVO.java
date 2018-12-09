package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.entity.GeographicLocationEntity;
import com.waterpls.waterpls.domain.validator.GeoCoordinateValidator;

public class GeographicLocationVO extends ValueObject {

  private GeoCoordinateVO latitude;
  private GeoCoordinateVO longitude;
  private GeoCoordinateValidator validator;

  public GeographicLocationVO(GeoCoordinateVO latitude, GeoCoordinateVO longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeographicLocationVO(GeographicLocationEntity entity) {
    latitude = new GeoCoordinateVO(entity.getLatitude(),
        new GeoCoordinateValidator(entity.getLatitude()));
    longitude = new GeoCoordinateVO(entity.getLongitude(),
        new GeoCoordinateValidator(entity.getLongitude()));
  }

  public GeoCoordinateVO getLatitude() {
    return latitude;
  }

  public GeoCoordinateVO getLongitude() {
    return longitude;
  }

  public float getLatitudeValue() {
    return latitude.getCoordinate();
  }

  public float getLongitudeValue() {
    return longitude.getCoordinate();
  }
}
