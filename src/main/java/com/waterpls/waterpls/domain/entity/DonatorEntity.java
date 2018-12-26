package com.waterpls.waterpls.domain.entity;

import com.waterpls.waterpls.domain.dto.NameDTO;
import com.waterpls.waterpls.domain.dto.PasswordDTO;
import com.waterpls.waterpls.domain.dto.UsernameDTO;
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
public class DonatorEntity extends RootEntity {

  @Embedded
  private UsernameDTO username;

  @Embedded
  private PasswordDTO password;

  @Embedded
  @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "first_name"))})
  private NameDTO firstName;

  @Embedded
  @AttributeOverrides({@AttributeOverride(name = "name", column = @Column(name = "last_name"))})
  private NameDTO lastName;

  @OneToOne(cascade = CascadeType.ALL)
  private GeographicLocationEntity location;

  public DonatorEntity() {

  }

  public DonatorEntity(UsernameDTO username, PasswordDTO password, NameDTO firstName,
      NameDTO lastName,
      GeographicLocationEntity location) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.location = location;
  }

  public DonatorEntity(NameVO firstName, NameVO lastName,
      GeographicLocationVO location) {
    this.firstName = new NameDTO(firstName.getName());
    this.lastName = new NameDTO(lastName.getName());
    this.location = new GeographicLocationEntity(location);
  }

  public UsernameDTO getUsername() {
    return username;
  }

  public void setUsername(UsernameDTO username) {
    this.username = username;
  }

  public PasswordDTO getPassword() {
    return password;
  }

  public void setPassword(PasswordDTO password) {
    this.password = password;
  }

  public NameDTO getFirstName() {
    return firstName;
  }

  public void setFirstName(NameDTO firstName) {
    this.firstName = firstName;
  }

  public NameDTO getLastName() {
    return lastName;
  }

  public void setLastName(NameDTO lastName) {
    this.lastName = lastName;
  }

  public GeographicLocationEntity getLocation() {
    return location;
  }

  public void setLocation(GeographicLocationEntity location) {
    this.location = location;
  }
}
