package com.waterpls.waterpls.domain.entity;

import com.waterpls.waterpls.domain.value.GeographicLocationVO;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class GeographicLocationEntity extends RootEntity {

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "coordinate", column = @Column(name = "latitude"))})
  private GeoCoordinateEntity latitude;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "coordinate", column = @Column(name = "longitude"))})
  private GeoCoordinateEntity longitude;

  public GeographicLocationEntity() {

  }

  public GeographicLocationEntity(GeographicLocationVO geographicLocationVO) {
    latitude = new GeoCoordinateEntity(geographicLocationVO.getLatitude());
    longitude = new GeoCoordinateEntity(geographicLocationVO.getLongitude());
  }

  public GeographicLocationEntity(GeoCoordinateEntity latitude, GeoCoordinateEntity longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoCoordinateEntity getLatitude() {
    return latitude;
  }

  public void setLatitude(GeoCoordinateEntity latitude) {
    this.latitude = latitude;
  }

  public GeoCoordinateEntity getLongitude() {
    return longitude;
  }

  public void setLongitude(GeoCoordinateEntity longitude) {
    this.longitude = longitude;
  }
}
