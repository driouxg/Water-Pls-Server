package com.waterpls.waterpls.domain.entity;

import com.waterpls.waterpls.domain.dto.GeoCoordinateDTO;
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
  private GeoCoordinateDTO latitude;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "coordinate", column = @Column(name = "longitude"))})
  private GeoCoordinateDTO longitude;

  public GeographicLocationEntity() {

  }

  public GeographicLocationEntity(GeographicLocationVO geographicLocationVO) {
    latitude = new GeoCoordinateDTO(geographicLocationVO.getLatitude());
    longitude = new GeoCoordinateDTO(geographicLocationVO.getLongitude());
  }

  public GeographicLocationEntity(GeoCoordinateDTO latitude, GeoCoordinateDTO longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoCoordinateDTO getLatitude() {
    return latitude;
  }

  public void setLatitude(GeoCoordinateDTO latitude) {
    this.latitude = latitude;
  }

  public GeoCoordinateDTO getLongitude() {
    return longitude;
  }

  public void setLongitude(GeoCoordinateDTO longitude) {
    this.longitude = longitude;
  }
}
