package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.validator.NameValidator;

public class Name extends ValueObject {

  private String name;
  private NameValidator nameValidator;

  public Name(String name) {
    nameValidator = new NameValidator(name);
    this.name = name;
  }

  private void validateName() {
    nameValidator.isAlphaNumeric();
    nameValidator.isLessThan25Characters();
  }
}
