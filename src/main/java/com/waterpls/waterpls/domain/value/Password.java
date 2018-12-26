package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.validator.PasswordValidator;

public class Password extends ValueObject {

  private String password;
  private PasswordValidator passwordValidator;

  public Password(String password, PasswordValidator passwordValidator) {
    this.password = password;
    this.passwordValidator = passwordValidator;
    validate();
  }

  public String getPassword() {
    return password;
  }

  public void validate() {
    passwordValidator.hasAtLeastOneSpecialCharacter();
    passwordValidator.hasAtLeast8Characters();
  }
}
