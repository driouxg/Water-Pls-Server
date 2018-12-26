package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.validator.NameValidator;

public class Username extends ValueObject {
  private String username;
  private NameValidator nameValidator;

  public Username(String username, NameValidator nameValidator) {
    this.username = username;
    this.nameValidator = nameValidator;
  }

  public String getUsername() {
    return username;
  }

  public void validate() {
    nameValidator.hasNoWhitespace();
    nameValidator.isAlphaNumeric();
    nameValidator.isLessThan25Characters();
    nameValidator.hasCharacters();
  }
}
