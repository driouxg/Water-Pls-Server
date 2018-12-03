package com.waterpls.waterpls.domain.validator;

import com.waterpls.waterpls.domain.exception.NameException;

public class NameValidator {

  private String name;

  public NameValidator(String name) {
    this.name = name;
  }

  public void isAlphaNumeric() {
    if (!name.matches("[a-zA-Z0-9]+")) {
      throw new NameException("Invalid name: is not alphaNumeric.");
    }
  }

  public void isLessThan25Characters() {
    if (name.length() > 25) {
      throw new NameException("Invalid name: contains more than 25 characters.");
    }
  }

  public void hasCharacters() {
    if (name.length() <= 0) {
      throw new NameException("Invalid name: name is empty");
    }
  }
}
