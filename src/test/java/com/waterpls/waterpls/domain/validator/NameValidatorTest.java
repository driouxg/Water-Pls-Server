package com.waterpls.waterpls.domain.validator;

import com.waterpls.waterpls.domain.exception.NameException;
import org.junit.Before;
import org.junit.Test;

public class NameValidatorTest {

  private NameValidator nameValidator;

  @Test
  public void isAlphaNumeric_hasValidName_doesNotThrowException() {
    nameValidator = new NameValidator("username");
    nameValidator.isAlphaNumeric();
  }

  @Test(expected = NameException.class)
  public void isAlphaNumeric_hasNameWithSpecialCharacters_throwsException() {
    nameValidator = new NameValidator("username!");
    nameValidator.isAlphaNumeric();
  }

  @Test
  public void isLessThan25Characters_nameHasLessThan25Characters_doesNotThrowException() {
    nameValidator = new NameValidator("username");
    nameValidator.isLessThan25Characters();
  }

  @Test(expected = NameException.class)
  public void isLessThan25Characters_nameHasMoreThan25Characters_throwsException() {
    nameValidator = new NameValidator("abcdefghijklmnopqrstuvwxyz25");
    nameValidator.isLessThan25Characters();
  }

  @Test
  public void hasNoWhitespace_nameHasNoWhiteSpace_doesNotThrowException() {
    nameValidator = new NameValidator("username");
    nameValidator.hasNoWhitespace();
  }

  @Test(expected = NameException.class)
  public void hasNoWhitespace_nameHasWhitespace_throwsException() {
    nameValidator = new NameValidator("user name");
    nameValidator.hasNoWhitespace();
  }

  @Test
  public void hasCharacters() {
  }
}