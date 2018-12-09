package com.waterpls.waterpls.domain.entity;

import com.waterpls.waterpls.domain.value.GeographicLocationVO;
import com.waterpls.waterpls.domain.value.NameVO;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class DonaterEntity extends RootEntity {

  @Embedded
  @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "first_name"))})
  private NameEntity firstName;

  @Embedded
  @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "last_name"))})
  private NameEntity lastName;

  @OneToOne(cascade = CascadeType.ALL)
  private GeographicLocationEntity location;

  public DonaterEntity() {

  }

  public DonaterEntity(NameEntity firstName, NameEntity lastName,
      GeographicLocationEntity location) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  public DonaterEntity(NameVO firstName, NameVO lastName,
      GeographicLocationVO location) {
    this.firstName = new NameEntity(firstName.getName());
    this.lastName = new NameEntity(lastName.getName());
    this.location = new GeographicLocationEntity(location);
  }

  public NameEntity getFirstName() {
    return firstName;
  }

  public void setFirstName(NameEntity firstName) {
    this.firstName = firstName;
  }

  public NameEntity getLastName() {
    return lastName;
  }

  public void setLastName(NameEntity lastName) {
    this.lastName = lastName;
  }

  public GeographicLocationEntity getLocation() {
    return location;
  }

  public void setLocation(GeographicLocationEntity location) {
    this.location = location;
  }
}
