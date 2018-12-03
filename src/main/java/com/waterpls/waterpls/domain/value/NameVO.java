package com.waterpls.waterpls.domain.value;

import com.waterpls.waterpls.domain.dto.NameDTO;
import com.waterpls.waterpls.domain.entity.NameEntity;
import com.waterpls.waterpls.domain.validator.NameValidator;

public class NameVO extends ValueObject {

  private String name;
  private NameValidator validator;

  public NameVO(String name, NameValidator validator) {
    this.name = name;
    this.validator = validator;
    validateName();
  }

  public NameVO(NameDTO nameDTO, NameValidator validator) {
    this.name = nameDTO.getName();
    this.validator = validator;
    validateName();
  }

  public NameVO(NameEntity nameEntity, NameValidator validator) {
    name = nameEntity.getName();
    this.validator = validator;
    validateName();
  }

  private void validateName() {
    validator.isAlphaNumeric();
    validator.isLessThan25Characters();
    validator.hasCharacters();
  }

  public String getName() {
    return name;
  }
}
