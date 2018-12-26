package com.waterpls.waterpls.domain.validator;

import com.waterpls.waterpls.domain.exception.PasswordException;

public class PasswordValidator {

  private String password;

  public PasswordValidator(String password) {
    this.password = password;
  }

  public void hasAtLeastOneSpecialCharacter() {
    if (!password.matches("[!$&*%#@]")) {
      throw new PasswordException("Invalid password: Must contain at least one special character.");
    }
  }

  public void hasAtLeast8Characters() {
    if (password.length() < 8) {
      throw new PasswordException("Invalid password: Must contain at least eight characters.");
    }
  }
}
