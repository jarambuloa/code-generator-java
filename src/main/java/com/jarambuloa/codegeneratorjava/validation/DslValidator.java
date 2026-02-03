package com.jarambuloa.codegeneratorjava.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

public class DslValidator {
  
  private static final Validator validator =
      Validation.buildDefaultValidatorFactory().getValidator();
  
  public static <T> void validate(T object) {
    Set<ConstraintViolation<T>> violations = validator.validate(object);
    
    if (!violations.isEmpty()) {
      StringBuilder sb = new StringBuilder("\n❌ Errores en el DSL:\n\n");
      
      for (ConstraintViolation<T> v : violations) {
        sb.append(" - ")
            .append(v.getPropertyPath())
            .append(": ")
            .append(v.getMessage())
            .append("\n");
      }
      
      throw new IllegalStateException(sb.toString());
    }
  }
}
